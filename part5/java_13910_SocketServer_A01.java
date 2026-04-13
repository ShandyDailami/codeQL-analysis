import java.io.*;
import java.net.*;

public class java_13910_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create new streams for client and server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Start handshake
                out.writeUTF("Connection established, please send your data");
                String serverMsg = in.readUTF();
                System.out.println("Server says: " + serverMsg);

                // Handle the communication
                String clientMsg = in.readUTF();
                out.writeUTF("Data received: " + clientMsg);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}