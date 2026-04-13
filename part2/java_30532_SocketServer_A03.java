import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_30532_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Connection accepted from : " + clientSocket.getRemoteSocketAddress());

                SSLCertificate certificate = (SSLCertificate) clientSocket.getSession().getPeerCertificate();
                System.out.println("Client certificate : " + certificate);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                out.writeUTF("Connection Successful. You can type a message and I will repeat what I heard back.");
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.writeUTF("Server received: " + message);
                }
                clientSocket.close();
            }
        } catch (SSLException e) {
            System.out.println("SSL Exception occurred: " + e.getMessage());
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }
}