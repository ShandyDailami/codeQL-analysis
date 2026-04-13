import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18405_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            // Security-sensitive operation: IntegrityFailure
            if (message.contains("failure")) {
                outputStream.writeUTF("IntegrityFailure");
            } else {
                outputStream.writeUTF("Success");
            }

            outputStream.flush();
            socket.close();
        }
    }
}