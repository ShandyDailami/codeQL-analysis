import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06098_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Create new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error while setting up the server: " + e.getMessage());
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_06098_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Receive the message from the client
                String message = socket.getInputStream().readUTF();
                System.out.println("Received: " + message);

                // Send the received message back to the client
                socket.getOutputStream().writeUTF(message);
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            System.out.println("Error while handling the client: " + e.getMessage());
       
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}