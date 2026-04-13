import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40536_SocketServer_A01 {

    private ServerSocket serverSocket;
    private Socket clientSocket;

    public java_40536_SocketServer_A01(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(clientSocket);
            } catch (IOException e) {
                System.out.println("Error handling client connection");
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleClient(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);

            if (authenticateUser(clientMessage)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client");
            e.printStackTrace();
        }
    }

    private boolean authenticateUser(String userInput) {
        // Simulate authentication by comparing user input to a hard-coded password
        // In a real application, this would typically be replaced with a more secure method
        return userInput.equals("password");
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(54321);
        server.startServer();
    }
}