import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38720_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
       
            System.exit(1);
        }

        System.out.println("Waiting for client on port " + serverSocket.getLocalPort());

        SSLSocket clientSocket = null;
        try {
            clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client accepted!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send a message to the client
            out.writeUTF("Hello Client, you are authenticated!");
            out.flush();

            // Read a message from the client
            String message = in.readLine();
            System.out.println("Server received: " + message);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}