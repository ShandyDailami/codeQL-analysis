import java.io.*;
import java.net.*;

public class java_22337_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                // new thread to handle client request
                Thread thread = new Thread(new SocketRequestHandler(socket));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}

class SocketRequestHandler implements Runnable {
    private Socket socket;

    public java_22337_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // for simplicity, we'll just echo back the message
                writer.writeBytes(message + "\n");
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error handling client request: " + ex.getMessage());
        }
    }
}