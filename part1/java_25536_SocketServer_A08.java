import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25536_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4445);
            System.out.println("Server is listening on port 4445");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the client request
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_25536_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            // Send a response back to the client
            socket.getOutputStream().write("Message received: " + message.toUpperCase().getBytes());

            socket.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}