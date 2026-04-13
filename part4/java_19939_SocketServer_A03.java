import java.io.*;
import java.net.*;

public class java_19939_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            // Print a message to the console
            System.out.println("A client has connected!");

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_19939_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Send a message back to the client
            output.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress() + "!");
            output.flush();

            // Close the socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}