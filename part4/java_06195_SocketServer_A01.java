import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06195_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle the client in a separate thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_06195_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // Process the data
            String data = new String(buffer);
            System.out.println("Received: " + data);

            // Send a response
            String response = "Server response: " + data;
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}