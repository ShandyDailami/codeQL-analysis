import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17685_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Step 1: Creating a server socket on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server is listening on port 1234...");

        // Step 2: Accepting incoming connections
        Socket socket = serverSocket.accept();

        // Step 3: Handling the communication with the client
        // Here, we'll just echo back the message received.
        // This is a very simple example, in a real application you'd likely want to
        // handle multiple clients and multithreaded tasks.
        while (true) {
            byte[] bytes = socket.getInputStream().readAllBytes();
            String message = new String(bytes);
            System.out.println("Received message: " + message);

            // Step 4: Echo back the received message
            byte[] sendBytes = message.getBytes();
            socket.getOutputStream().write(sendBytes);

            // Step 5: Closing the connection
            socket.getOutputStream().close();
            socket.close();
        }
    }
}