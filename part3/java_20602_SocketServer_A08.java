import java.io.*;
import java.net.*;

public class java_20602_SocketServer_A08 {
    private static final int PORT = 8080;
    private static Socket socket;
    private static ServerSocket server;
    private static DataInputStream input;
    private static DataOutputStream output;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            socket = server.accept();
            System.out.println("Client connected");

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String clientMsg;

            while ((clientMsg = input.readUTF()) != null) {
                if (clientMsg.equals("exit")) {
                    socket.close();
                    server.close();
                    System.out.println("Connection closed");
                    break;
                }

                // Process the message: add integrity check
                // (e.g. check if the message is a valid UUID, etc.)

                output.writeUTF("Server: " + clientMsg);
                output.flush();
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}