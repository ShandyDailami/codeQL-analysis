import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32911_SocketServer_A07 {

    private static final int PORT = 9876; // you can change this port number as per your need

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Perform authentication here. Here, we'll just check if the client is connected
                if (authenticateClient(clientSocket)) {
                    handleClient(clientSocket);
                } else {
                    System.out.println("Authentication failed, closing connection with client!");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Here, we'll just perform a basic check. In a real-world scenario, you'd want to use SSL for authentication.
        return socket.isConnected();
    }

    private static void handleClient(Socket socket) {
        // Handle client here. In a real-world scenario, you'd want to use a thread for each client.
        // For simplicity, we'll just print out a message.
        try {
            socket.getInputStream().read();
            System.out.println("Handling client...");
            Thread.sleep(5000); // sleep for 5 seconds
            System.out.println("Done handling client!");
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}