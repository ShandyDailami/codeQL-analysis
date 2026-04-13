import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_26955_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted a new connection from " + clientSocket.getRemoteSocketAddress());

                // Create input and output stream
                OutputStream outToClient = clientSocket.getOutputStream();
                InputStream inFromClient = clientSocket.getInputStream();

                // Write the data received from the client
                DataOutputStream out = new DataOutputStream(outToClient);
                out.writeUTF("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + "\n");

                // Close the connection
                out.close();
                clientSocket.close();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}