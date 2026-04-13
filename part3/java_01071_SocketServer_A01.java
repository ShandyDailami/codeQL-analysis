import java.net.ServerSocket;
import java.net.Socket;

public class java_01071_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket and bind it to a port
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started at port 1234");

            // Step 2: Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send and receive messages
            // Here we'll just echo back whatever is received
            String message = socket.getInputStream().readUTF();
            System.out.println("Received: " + message);
            socket.getOutputStream().writeUTF(message);
            socket.getOutputStream().flush();

            // Step 4: Close the connection
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}