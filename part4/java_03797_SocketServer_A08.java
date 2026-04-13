import java.io.*;
import java.net.*;

public class java_03797_SocketServer_A08 {
    private static final int port = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Start reading
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive message from client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send response back to client
                String response = "Hello, client!";
                out.writeUTF(response);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}