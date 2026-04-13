import java.io.*;
import java.net.*;

public class java_23596_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        while (true) {
            Socket socket = server.accept();

            // Creating input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Checking for integrity failure
            if (message.contains("A08_IntegrityFailure")) {
                System.out.println("Integrity Failure Detected!");
                out.writeUTF("Integrity Failure Detected!");
            } else {
                System.out.println("No Integrity Failure detected.");
                out.writeUTF("No Integrity Failure detected.");
            }

            // Closing the connection
            out.close();
            socket.close();
        }
    }
}