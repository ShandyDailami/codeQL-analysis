import java.io.*;
import java.net.*;

public class java_26214_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            // For security-sensitive operations, we can't send back the same message
            // because it could be intercepted by the client.
            // Instead, we'll just echo the message back.
            out.writeUTF(message);
            out.flush();

            socket.close();
       
        }
    }
}