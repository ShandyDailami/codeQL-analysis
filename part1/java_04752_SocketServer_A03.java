import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04752_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Creating a ServerSocket on a specific port.
            ServerSocket serverSocket = new ServerSocket(6000);

            System.out.println("Server is listening on port 6000.");

            while (true) {
                // Blocks until a client connects to the server.
                Socket clientSocket = serverSocket.accept();

                System.out.println("A client has connected.");

                // Starts a new thread to handle communication with the client.
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_04752_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // TODO: Handle client communication here using standard libraries.
    }
}