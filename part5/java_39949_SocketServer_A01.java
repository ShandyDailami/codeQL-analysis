import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39949_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle the client connection here
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_39949_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, the server handles the client's request for data
            // However, since we are focusing on security-sensitive operations related to A01_BrokenAccessControl,
            // we are not implementing the functionality here. You would implement this in a real-world application.
            // For example, we could read data from the client, verify it, and then send a response.

            // You can also implement authentication and authorization here, for example, checking the username and password.
            // For example, you could read the username and password from the client, and then verify them against a database.

            // For the sake of simplicity, we'll just write the received data back to the client.
            String receivedData = new String(socket.getInputStream().readAllBytes(), "UTF-8");
            socket.getOutputStream().write(receivedData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}