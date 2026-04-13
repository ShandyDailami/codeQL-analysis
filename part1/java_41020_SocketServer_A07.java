import java.io.*;
import java.net.*;

public class java_41020_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start of AuthFailure Handling code
            // Generate and send a random challenge
            String challenge = Integer.toString((int) (Math.random() * 10000));
            out.writeUTF("Challenge: " + challenge);
            out.flush();

            // Receive client's response
            String response = in.readUTF();
            if (response.equals("Challenge: " + challenge)) {
                out.writeUTF("Authentication successful.");
            } else {
                out.writeUTF("Authentication failed.");
            }
            out.flush();
            // End of AuthFailure Handling code

            socket.close();
        }
    }
}