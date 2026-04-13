import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39924_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Authentication phase here. We're just checking if the client sent us a valid username.
                String username = input.readUTF();
                if ("valid_username".equals(username)) {
                    output.writeUTF("Authentication successful");
                } else {
                    output.writeUTF("Authentication failed");
                    continue;
                }

                // Handle the request as it comes in from the client here.
                String request = input.readUTF();
                output.writeUTF("Server received: " + request);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}