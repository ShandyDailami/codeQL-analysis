import java.io.*;
import java.net.*;

public class java_06624_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            // Receive and echo back a message
            String message = in.readUTF();
            out.writeUTF(message);

            // Close the connection
            client.close();
        }
    }
}