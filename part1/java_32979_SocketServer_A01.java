import java.io.*;
import java.net.*;

public class java_32979_SocketServer_A01 {
    public static void main(String[] args) {
        // Create a socket for listening incoming connections
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000); // Assign any port you wish
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Waiting for a client to connect...");

        Socket socket = null;
        try {
            // Accepts the client that is trying to connect
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client connected!");

        // Create a writer and reader for communication
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read a line from the client
        String request;
        try {
            request = in.readLine();
            System.out.println("Received: " + request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Send a response to the client
        out.println("Server response");
    }
}