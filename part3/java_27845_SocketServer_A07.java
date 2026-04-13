import java.net.*;
import java.io.*;

public class java_27845_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        int port = 4445;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the client message
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Authentication (A07_AuthFailure)
            if (message.equals("authentication")) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
           
            }

            out.flush();
            socket.close();
        }
    }
}