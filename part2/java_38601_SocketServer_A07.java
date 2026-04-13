import java.io.*;
import java.net.*;

public class java_38601_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a server socket at a specific port.
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345.");

            while (true) {
                // Step 2: Wait for a client to connect.
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected.");

                // Step 3: Create a thread for communication with the client.
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_38601_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Step 4: Get input and output streams from the socket.
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Step 5: Create a buffer for incoming data.
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            // Step 6: Handle the incoming data and send a response back to the client.
            if (bytesRead != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);

                String response = "Hello, " + message;
                output.write(response.getBytes());
                System.out.println("Sent response: " + response);
            }

            // Step 7: Close the socket connection.
            socket.close();
            System.out.println("Client disconnected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}