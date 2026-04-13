import java.io.*;
import java.net.*;

public class java_05391_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a server socket and listen on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            // Step 2: Accept a new connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send a response to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Thank you for connecting to " + socket.getLocalSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}