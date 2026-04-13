import java.io.*;
import java.net.*;

public class java_28226_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 5000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Thread for handling client requests
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_28226_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Receive a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Handle the message and send a response back to the client
            if ("Hello, World!".equals(message)) {
                out.writeBytes("Thanks for connecting! \n");
            } else {
                out.writeBytes("Unrecognized message. Ignoring.\n");
            }

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}