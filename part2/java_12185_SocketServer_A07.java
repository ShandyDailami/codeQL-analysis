import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12185_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a server socket and listen on port 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Wait for a client to connect
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread to handle communication with the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error while listening for connections: " + e.getMessage());
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_12185_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Handle incoming communication from the client
            while (true) {
                // TODO: Implement your security-sensitive operations here
                // For now, we'll just read and echo back the data
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    break;
                }
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error while handling communication: " + e.getMessage());
        }
    }
}