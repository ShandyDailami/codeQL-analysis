import java.io.*;
import java.net.*;

public class java_30445_SocketServer_A08 {

    private static final int PORT = 8080;
    private static Socket socket;
    private static ServerSocket server;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            socket = server.accept();
            System.out.println("Client connected");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Client says: " + message);
                out.writeUTF("Server says: " + message);
           
                // Security-sensitive operations related to A08_IntegrityFailure
                // Here, we assume that the server is sending the same data back
                // This can be easily modified to send different data or perform any other security-sensitive operations
                out.writeUTF("Server says: " + message);
            }

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}