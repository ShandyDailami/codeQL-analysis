import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41378_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Perform security-sensitive operations related to A01_BrokenAccessControl here
            // For example, check the access rights of the client and deny access if it does not meet the requirements

            // Create a new thread for each client to handle their request
            new HandleClientThread(socket).start();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_41378_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client request here
        // For example, print out the message sent by the client
        try {
            String message = "Received: " + socket.getInputStream().readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            socket.getOutputStream().writeUTF("Response: " + message);
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}