import java.net.ServerSocket;
import java.net.Socket;

public class java_21456_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Perform secure operations (like encryption and decryption) here
                // For simplicity, let's print the received data for now
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Message received";
                socket.getOutputStream().write(response.getBytes());
                socket.getOutputStream().flush();
           
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}