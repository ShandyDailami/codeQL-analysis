import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40312_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Here we're using a simple approach to check for SQL injection attacks
                // In a real application, more sophisticated techniques would be used to prevent injection
                if (message.contains("drop table")) {
                    output.writeUTF("You're trying to drop a table, which is a security risk!");
                } else {
                    output.writeUTF("Message received successfully!");
                }

                output.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}