import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19269_SocketServer_A03 {
    private static final int PORT = 9876; // The port to listen on

    public static void main(String[] args) {
        // Create a server socket and listen on the specified port
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread to handle the communication
                new HandlerThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    private final Socket socket;

    public java_19269_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams from the socket
            java.io.DataInputStream input = new java.io.DataInputStream(socket.getInputStream());
            java.io.DataOutputStream output = new java.io.DataOutputStream(socket.getOutputStream());

            // Read a line of input from the client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            output.writeUTF(response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}