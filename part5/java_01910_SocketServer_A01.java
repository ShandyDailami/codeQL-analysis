import java.io.*;
import java.net.*;

public class java_01910_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_01910_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // Create a buffered reader for reading from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a buffered writer for writing to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Read a message from the client
            String message = reader.readLine();

            // Forward the received message to the client
            writer.println(message);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}