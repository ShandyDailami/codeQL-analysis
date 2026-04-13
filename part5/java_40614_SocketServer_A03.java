import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40614_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a new ServerSocket.
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for client connection...");

            // Step 2: Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Step 3: Handle communication with the client
            // (This is a very basic example and real server would be more complex)
            while (true) {
                // Receive a message from the client
                String message = socket.getInputStream().readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                socket.getOutputStream().writeUTF("Thank you for connecting!");
                socket.getOutputStream().flush();
            }

            // Step 4: Close the connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}