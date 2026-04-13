import java.io.*;
import java.net.*;

public class java_22828_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeUTF("Connection established");

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Client says: " + message);

                // Send a message back to the client
                out.writeUTF("Server says: " + message);
            }

            socket.close();
        }
    }
}