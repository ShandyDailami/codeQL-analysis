import java.io.*;
import java.net.*;

public class java_41030_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // create new thread for each client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public java_41030_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String clientMessage = input.readUTF();
            System.out.println("Received: " + clientMessage);

            // process message and send response
            String serverMessage = "Server received: " + clientMessage;
            output.writeUTF(serverMessage);
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}