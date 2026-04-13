import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11736_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running and waiting for a client to connect...");

            Socket client = server.accept();
            System.out.println("Client has connected!");

            // Start a new thread to handle the client
            new ClientHandler(client).start();

        } catch (IOException e) {
            System.out.println("Server couldn't start. Error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public java_11736_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            // Get input and output streams
            // Here we assume client and server are secure (no encryption, no hacker)
            // In a real application, you should use SSL for encryption and secure communication.
            // Here, we use simple string parsing to simulate the situation.
            while (true) {
                String message = clientSocket.getInputStream().readUTF();
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    break;
                }

                // Here we assume server responds back to the client
                clientSocket.getOutputStream().writeUTF("Message received!");
                clientSocket.getOutputStream().flush();
            }

            // Close the connection
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Client couldn't handle the client. Error: " + e.getMessage());
        }
    }
}