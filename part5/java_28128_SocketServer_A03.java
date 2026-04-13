import java.io.*;
import java.net.*;

public class java_28128_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is running on port 5000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = processMessage(message);
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processMessage(String message) {
        // This is a placeholder for the injection point.
        // In a real application, this could be a dangerous operation,
        // such as command injection or cross-site scripting (XSS) attacks.
        // In this example, we're just returning the message as it is.
        return message;
    }
}