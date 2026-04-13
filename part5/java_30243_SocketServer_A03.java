import java.io.*;
import java.net.*;

public class java_30243_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a socket server on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected...");

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_30243_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Read the message from the client
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, " + message + "!";
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}