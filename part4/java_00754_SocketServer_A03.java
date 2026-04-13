import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00754_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while trying to listen for client connections");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_00754_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add your code to handle the client connection and perform security-sensitive operations
            // For example, check if the client is making a request to a server that you don't want to allow
            // or perform the operations you need to, like reading from the client and sending a response
            // In this example, we just print out the client's address

            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Here you can add your code to read from the client and send a response
            // For example, we will send a simple message back to the client

            socket.getOutputStream().write("Hello, Client!".getBytes());
            socket.close();

        } catch (IOException e) {
            System.out.println("Error occurred while trying to handle client connection");
            e.printStackTrace();
        }
    }
}