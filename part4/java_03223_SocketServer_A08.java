import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03223_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started. Waiting for clients...");

            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage;

            while ((clientMessage = input.readUTF()) != null) {
                if (clientMessage.equals("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.println("Received: " + clientMessage);

                // TODO: Insert security-sensitive operations here, e.g., checking if the client message contains sensitive information.

                output.writeUTF("Server: " + clientMessage);
                output.flush();
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}