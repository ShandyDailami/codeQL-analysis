import java.io.*;
import java.net.*;

public class java_02129_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket on port 8080
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        // Accept incoming connections
        while (true) {
            Socket socket = server.accept();

            System.out.println("A client has connected!");

            // Create a new thread for handling communication with the client
            new Thread(() -> {
                try {
                    // Create input and output streams
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    String clientMessage;
                    // Read from the client
                    while ((clientMessage = in.readLine()) != null) {
                        System.out.println("Client says: " + clientMessage);

                        // Send a response back to the client
                        out.println("Server says: Hello, " + clientMessage);
                    }

                    // Close the connection
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}