import java.net.ServerSocket;
import java.net.Socket;

public class java_05576_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running on port 1234");

            while (true) {
                // Step 2: Accept incoming client
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Step 3: Handle client request
                // Here we're assuming that the client is just sending a simple message
                // and we're just responding with a "Hello, Client" message
                String message = socket.getInputStream().readUTF();
                String response = "Hello, Client";
                socket.getOutputStream().writeUTF(response);
                socket.getOutputStream().flush();

                // Close the connection
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}