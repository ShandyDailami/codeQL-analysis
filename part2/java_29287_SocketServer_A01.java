import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_29287_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send authentication status to client
            out.write("SSL/TLS Client Authentication Requested\n".getBytes());
            out.flush();

            // Wait for client to confirm authentication
            String userInput = in.readLine();
            while (userInput == null) {
                userInput = in.readLine();
            }

            if (userInput.equals("accept")) {
                // If client confirmed, write a message and close connection
                out.write("SSL/TLS Client Authentication Accepted\n".getBytes());
            } else {
                // If client did not confirm, write error message and close connection
                out.write("SSL/TLS Client Authentication Denied\n".getBytes());
           
            }
            out.flush();
            clientSocket.close();

        } catch (SSLException e) {
            System.err.println("SSLException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}