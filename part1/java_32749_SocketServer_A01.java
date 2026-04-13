import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32749_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here we create a new thread for each client
                // This is not the best way to handle this, it's just for example
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error creating server socket: " + ex);
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_32749_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Here you would normally handle the client communication
        // But since we're just testing access control, we'll just echo back everything
        try (socket.getInputStream(); socket.getOutputStream()) {
            int receive;
            while ((receive = socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write(receive);
            }
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex);
        }
    }
}