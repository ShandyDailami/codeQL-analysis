import java.io.*;
import java.net.*;

public class java_05209_SocketServer_A08 {

    public static void main(String[] args) {

        // Create a server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6565); // Specify the port
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server started at port " + serverSocket.getLocalPort() + ". Waiting for client ...");

        // Wait for a client to connect
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client connected");

        // Create a reader and writer
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Send a message to the client
        out.println("Server: Hello Client, How are you?");

        // Close the connections
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}