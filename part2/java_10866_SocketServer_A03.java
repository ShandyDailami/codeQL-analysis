import java.io.*;
import java.net.*;

public class java_10866_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket on port 1234
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            // Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for handling the client
            HandlerThread handlerThread = new HandlerThread();
            handlerThread.start();

            // Get the input and output streams for the client
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Create a new buffer for reading data from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Create a new buffer for writing data to the client
            DataOutputStream writer = new DataOutputStream(outputStream);

            // Send a message to the client
            writer.writeUTF("Hello, Client!");

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the server socket
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Inner class for handling client connections
    static class HandlerThread extends Thread {
        @Override
        public void run() {
            try {
                // Get the input and output streams for the client
                InputStream inputStream = this.socket.getInputStream();
                OutputStream outputStream = this.socket.getOutputStream();

                // Create a new buffer for reading data from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                // Create a new buffer for writing data to the client
                DataOutputStream writer = new DataOutputStream(outputStream);

                // Read a message from the client
                String message = reader.readUTF();
                System.out.println("Client says: " + message);

                // Send a response back to the client
                writer.writeUTF("Thank you for connecting!");

                // Close the connection
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}