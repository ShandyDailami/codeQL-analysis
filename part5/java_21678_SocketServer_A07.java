import java.io.*;
import java.net.*;

public class java_21678_SocketServer_A07 {

    private static final int PORT = 9876;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();

            // Implement your security-sensitive operations related to A07_AuthFailure here
            // This is a placeholder.
            String serverMessage = "Server received: " + clientMessage;

            out.writeUTF(serverMessage);
            out.flush();
       
            socket.close();
        }
    }
}