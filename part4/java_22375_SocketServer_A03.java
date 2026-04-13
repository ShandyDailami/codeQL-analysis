import java.io.*;
import java.net.*;

public class java_22375_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Server message";
    private static final String CLIENT_DISCONNECT_COMMAND = "disconnect";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started.");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected.");

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();

                if (!message.equals(CLIENT_DISCONNECT_COMMAND)) {
                    out.writeUTF(SERVER_MESSAGE);
                    out.flush();
                }

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}