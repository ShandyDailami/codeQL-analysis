import java.io.*;
import java.net.*;

public class java_40161_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234); // listen on port 1234
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept(); // wait for client connection
            System.out.println("New client connected");

            // Handle the client in a separate thread
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    Socket socket;

    Handler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the message from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();

            // Authentication failure (A07_AuthFailure)
            // Here we just simulate it, in real world we should use some authentication library
            if (message.equals("authFailed")) {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Authentication failed");
                socket.close();
            } else {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Message received: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}