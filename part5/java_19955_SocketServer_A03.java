import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19955_SocketServer_A03 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Handling the client connection in a separate thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_19955_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform security sensitive operations here
            // For example, reading from the socket and executing any necessary operations
            // This is a placeholder and does not represent a real implementation
            // Read from the socket
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // TODO: Perform security-sensitive operations here

            // TODO: Write response to the client

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}