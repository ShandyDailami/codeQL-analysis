import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05309_SocketServer_A03 {
    private static final int PORT = 4445; // Define a port for the server

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                
                // Handle the client connection here
                // For the sake of simplicity, we'll just echo back the data received
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_05309_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from the client
            // This is a simplistic example, no security measures are taken place
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                
                if (bytesRead == -1) {
                    break;
                }
                
                // Echo the data back to the client
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}