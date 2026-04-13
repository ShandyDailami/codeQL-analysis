import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_37309_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10000,
                    (SocketFilter) keyStore, true);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client on port " + serverSocket.getPort());

            socket = (SSLSocket) serverSocket.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            socket.startHandshake();
            SSLSession session = socket.getSession();
            System.out.println("SSL Session established : " + session);

            // Now you can write to and read from the socket

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Client!");

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String reply = reader.readLine();
            System.out.println("Server : " + reply);

        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}