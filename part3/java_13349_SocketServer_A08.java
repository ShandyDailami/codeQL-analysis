import java.net.ServerSocket;
import java.net.Socket;

public class java_13349_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000); // create a ServerSocket on port 8000
            System.out.println("Server is listening on port 8000");

            while (true) { // infinite loop to accept multiple clients
                Socket socket = server.accept(); // accept a client connection
                System.out.println("Client connected");

                // receive a message from the client
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);
                System.out.println("Received: " + message);

                // send a message to the client
                String response = "Hello, Client!";
                socket.getOutputStream().write(response.getBytes());
                System.out.println("Sent: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}