import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41548_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            Socket socket = serverSocket.accept();
            System.out.println("Connected with client " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Here is the place for security-sensitive operations related to A08_IntegrityFailure

            out.writeUTF("Server successfully processed the message");
            System.out.println("Message successfully processed");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}