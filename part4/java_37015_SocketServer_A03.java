import java.io.*;
import java.net.*;

public class java_37015_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create a new thread for handling the client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_37015_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read and send back the message from the client
            byte[] bytes = new byte[1000];
            input.read(bytes);
            String message = new String(bytes);
            output.write(message.getBytes());

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}