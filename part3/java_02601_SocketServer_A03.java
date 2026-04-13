import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02601_SocketServer_A03 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                // Create input stream from client socket
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                // Create output stream to client socket
                OutputStream out = client.getOutputStream();

                // Handle client messages
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.write("Server: Received your message. Thank you! \n".getBytes());
                    out.flush();
                }

                // Close connections
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}