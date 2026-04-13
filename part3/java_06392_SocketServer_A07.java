import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_06392_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        //Create SSLServerSocket and get ready to receive request from a client.
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true); // set need client auth

            System.out.println("Waiting for client on port " + serverSocket.getPort() + "...");

            //Accept client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            //Send message to the client.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello Client, Welcome to Socket Programming.");

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Received: " + response);
            }

            //Close the connection
            clientSocket.close();
        } finally {
            serverSocket.close();
        }
    }
}