import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30931_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket and a new server socket
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                // Accept a new client
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// A class to handle each client
class ClientHandler extends Thread {
    private Socket socket;

    public java_30931_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams
            InetAddress clientAddress = socket.getInetAddress();
            System.out.println("Client " + clientAddress.getHostAddress() + " is connected");

            // Create a new input and output stream for the client
            Socket clientSocket = new Socket(clientAddress, 5555);

            // Send a welcome message to the client
            clientSocket.getOutputStream().write("Welcome to the server!".getBytes());

            // Close the client socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}