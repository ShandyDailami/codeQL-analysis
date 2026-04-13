import java.io.*;
import java.net.*;

public class java_21374_SocketServer_A08 {

    // Main method to bootstrap the server
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create a new thread for each client connection
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

// Class to handle individual client connections
class SocketHandler implements Runnable {

    private Socket socket;

    public java_21374_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            InputStream inputStream = this.socket.getInputStream();
            OutputStream outputStream = this.socket.getOutputStream();

            // Create buffers for receiving and sending data
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Read the message from the client
            String message = dataInputStream.readUTF();

            // Send the message back to the client
            dataOutputStream.writeUTF("Server received: " + message);

            // Close the streams
            dataInputStream.close();
            dataOutputStream.close();

            // Close the socket
            this.socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}