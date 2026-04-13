import java.io.*;
import java.net.*;

public class java_22589_SocketServer_A01 {
    private int port;
    private ServerSocket serverSocket;

    public java_22589_SocketServer_A01(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        System.out.println("Server started on port: " + port);
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                handleClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            // Here is where we implement security-related operations.
            // For example, we are creating a new message and sending it back to the client.
            String secureMessage = "This is a secure message!";
            output.writeUTF(secureMessage);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(1234);
        server.startServer();
    }
}