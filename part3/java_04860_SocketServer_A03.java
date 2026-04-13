import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04860_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // create new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_04860_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle client request here
        // this is a simple example, you would need to implement the full request handling
        // for security sensitive operations like A03_Injection
    }
}