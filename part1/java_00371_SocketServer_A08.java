import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00371_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client Connected");

                SSLSocket sslSocket = (SSLSocket) socket.getWrappedSocket();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("OK");
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}