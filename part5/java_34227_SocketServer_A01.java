import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34227_SocketServer_A01 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create new thread for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port 8080");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_34227_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (socket) {
            // Send a response to the client
            socket.getOutputStream().write("Hello, Client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}