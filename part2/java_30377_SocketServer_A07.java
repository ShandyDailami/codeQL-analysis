import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30377_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Handle the client connection in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind to port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30377_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you would handle client communication, such as receiving data from the client,
        // sending data back to the client, etc.
        // For the sake of simplicity, we'll just print out the received data.
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    System.out.println("Client disconnected!");
                    socket.close();
                    break;
                }
                String receivedData = new String(buffer, 0, bytesRead);
                System.out.println("Received data: " + receivedData);
            }
        } catch (IOException e) {
            System.out.println("Error while handling client: " + socket.getInetAddress());
            e.printStackTrace();
        }
    }
}