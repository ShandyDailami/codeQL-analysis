import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23259_SocketServer_A07 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");
                handleClient(clientSocket);
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle client by creating a new thread
        Thread clientHandler = new Thread(new SocketHandler(clientSocket));
        clientHandler.start();
    }
}

class SocketHandler implements Runnable {
    private Socket clientSocket;

    public java_23259_SocketServer_A07(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Handle client communication here
    }
}