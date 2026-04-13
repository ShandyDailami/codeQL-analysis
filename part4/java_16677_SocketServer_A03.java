import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16677_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Handle the client connection and communication in a new thread
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_16677_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);

            // Print the received message
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}