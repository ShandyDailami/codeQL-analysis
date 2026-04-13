import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14847_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 1234; // define your port
        try {
            ServerSocket serverSocket = new ServerSocket(port); // create a server socket
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // accept a client connection
                System.out.println("Client connected");

                // Create a new thread to handle the client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_14847_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Verify the client's identity
            if (!clientSocket.getInetAddress().equals(clientSocket.getLocalAddress())) {
                System.out.println("Client identity verification failed");
                return;
            }

            // Verify the integrity of the data
            byte[] buffer = new byte[1024];
            int length = clientSocket.getInputStream().read(buffer);
            if (length != clientSocket.getInputStream().available()) {
                System.out.println("Data integrity verification failed");
                return;
            }

            // Send a message to the client
            clientSocket.getOutputStream().write("Hello, Client!".getBytes());
            clientSocket.getOutputStream().flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}