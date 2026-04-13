import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13533_SocketServer_A03 {
    private ServerSocket server;
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;

    public void startServer(int port) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received: " + message);

            // Perform injection attack here by directly writing the user input into the output stream
            out.writeUTF(message);
            out.flush();

            System.out.println("Message sent: " + message);
            client.close();
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer().startServer(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}