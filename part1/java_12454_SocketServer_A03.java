import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12454_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Thread for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_12454_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Here you can write your code for handling the client connection
            // For example, reading from and writing to the client

            // Read from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // Write to the client
            String response = "Hello client, you connected to the server!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}