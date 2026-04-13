import java.net.*;
import java.io.*;

public class java_28234_SocketServer_A01 {

    private static final int PORT = 8189;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started on port " + PORT);

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Create a new thread for the client
            ClientHandler clientThread = new ClientHandler(clientSocket);

            // Start the client thread
            clientThread.start();
        }
    }
}

class ClientHandler extends Thread {

    private final Socket clientSocket;

    public java_28234_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try (InputStream in = clientSocket.getInputStream();
             OutputStream out = clientSocket.getOutputStream()) {

            DataInputStream inStream = new DataInputStream(in);
            DataOutputStream outStream = new DataOutputStream(out);

            // Read the request
            String request = inStream.readUTF();

            // TODO: Implement the logic for the request (A01_BrokenAccessControl)

            // Send the response
            outStream.writeUTF("Server received the request");
            outStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}