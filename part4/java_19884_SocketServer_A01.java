import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19884_SocketServer_A01 {

    private static final int PORT = 8080; // Define the port number

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create a new thread for handling each client
                new Handler(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    Socket socket;

    public java_19884_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: handle client operations
        // For now, we'll just print out the remote socket's IP address
        System.out.println("Client IP address: " + socket.getInetAddress().getHostAddress());
    }
}