import java.io.*;
import java.net.*;

public class java_10434_SocketServer_A01 {

    // The port number for the Socket Server
    private static final int PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a server socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Accept client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}

class SocketHandler implements Runnable {

    private Socket clientSocket;

    public java_10434_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Create a new input stream from the client socket
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read a message from the client
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(response);

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}