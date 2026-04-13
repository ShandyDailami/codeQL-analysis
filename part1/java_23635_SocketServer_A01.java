import java.net.*;
import java.io.*;

public class java_23635_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create streams for reading and writing
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send message to client
            String message = "Hello Client!";
            out.writeUTF(message);
            System.out.println("Server sent message: " + message);

            // Close the streams
            in.close();
            out.close();
            socket.close();
        }
    }
}