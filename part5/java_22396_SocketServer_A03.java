import java.io.*;
import java.net.*;

public class java_22396_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server is listening on port 9000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create a new thread for handling each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_22396_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive a message from client
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Send a response back to client
            out.println("Hello, client!");

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}