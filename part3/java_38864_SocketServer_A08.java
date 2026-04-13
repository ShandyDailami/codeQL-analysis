import java.io.*;
import java.net.*;

public class java_38864_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            // Create input stream and output stream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from client
            String message = in.readUTF();

            // Respond with a message
            out.writeUTF("Hello, client, your message was: " + message);
            out.flush();

            // Close the connection
            socket.close();
        }
    }
}