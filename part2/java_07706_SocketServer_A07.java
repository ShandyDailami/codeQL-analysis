import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07706_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07706_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform the required operations here.
            // For example, read and write data using the socket.
            // Here we assume that the client will send a string and the server will respond with the same string.
            String message = socket.getInputStream().readUTF();
            System.out.println("Received message: " + message);

            String response = message;
            socket.getOutputStream().writeUTF(response);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}