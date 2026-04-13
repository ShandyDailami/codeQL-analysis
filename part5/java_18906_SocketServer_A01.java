import java.io.*;
import java.net.*;

public class java_18906_SocketServer_A01 {
    private static final int port = 60000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                if (clientMessage.equals("exit")) {
                    socket.close();
                    System.out.println("Client disconnected");
                } else {
                    // Sending message to client
                    String serverMessage = "Hello Client, I am a Server!";
                    out.writeUTF(serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}