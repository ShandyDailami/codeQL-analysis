import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36313_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " has connected.");

                // Here you would usually have a thread for each client.
                // However, since we're just starting a server, we'll just spawn
                // a new thread to handle the client.
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while setting up server. Port: " + port);
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_36313_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client here...
    }
}