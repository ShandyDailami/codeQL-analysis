import java.io.*;
import java.net.*;

public class java_15538_SocketServer_A01 {

    public static void main(String[] args) {

        int port = 60000; // default port
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // send welcome message
                out.writeUTF("Welcome to the server!");

                // receive and send a message
                String message = in.readUTF();
                System.out.println("Client says: " + message);
                out.writeUTF("Server says: Hello, client!");

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}