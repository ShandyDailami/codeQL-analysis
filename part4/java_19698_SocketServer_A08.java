import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_19698_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.Factory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            socket = (SSLSocket) serverSocket.accept();

            socket.startHandshake();
            SSLSession sslSession = socket.getSession();
            System.out.println("Server SSL Session created : " + sslSession.getId());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String line;

            while ((line = in.readLine()) != null) {
                System.out.println("Received : " + line);
                out.write((line + "\n").getBytes());
            }
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}