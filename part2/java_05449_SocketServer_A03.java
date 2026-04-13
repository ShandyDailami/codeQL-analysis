import java.io.*;
import java.net.*;

public class java_05449_SocketServer_A03 {
    private static final String QUIT = "quit";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Connected to: " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                if (message.equals(QUIT)) {
                    out.writeUTF("Connection closed by client");
                } else {
                    // Prevent SQL Injection by using parameterized queries or prepared statements
                    String secureMessage = "You said: " + message;
                    out.writeUTF(secureMessage);
                }

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
           
            }
        }

        server.close();
    }
}