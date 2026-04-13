import java.net.*;
import java.io.*;

public class java_02364_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 12345;

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");

            // Creating two threads for the communication
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_02364_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Creating input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Sending a response back to the client
            out.writeUTF("Server received your message: " + message);
            out.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}