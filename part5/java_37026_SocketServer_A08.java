import java.io.*;
import java.net.*;

public class java_37026_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080; // the port to listen on

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected!");

                // Create a new thread to handle the client communication
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error while setting up server: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_37026_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Create streams for the client and the server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received message from client: " + clientMessage);

                // Here, we are simulating an integrity failure. In a real-world application,
                // you would likely have more complex operations here. For example, you might
                // check the integrity of the received message and reject the connection if it is
                // not valid.

                // For the sake of simplicity, we will just send a response back to the client.
                out.println("Server response: Message received successfully");
            }

            // If the client closes the connection, the server should send back a message to the client
            // to indicate this.
            out.println("Server sent the message 'Client closed the connection'");

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error while handling client: " + e.getMessage());
        }
    }
}