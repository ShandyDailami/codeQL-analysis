import java.io.*;
import java.net.*;

public class java_07637_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Send response
            out.writeUTF("Hello, World!");
            out.flush();

            // Close the connection
            socket.close();
        }
    }
}