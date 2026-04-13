import java.io.*;
import java.net.*;

public class java_13029_SocketServer_A01 {
    private static final String SERVER_PASSWORD = "secret";
    private static boolean passwordSet = false;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientPassword = dataInputStream.readUTF();

            if (!passwordSet || !clientPassword.equals(SERVER_PASSWORD)) {
                System.out.println("Client connection failed. Password was incorrect.");
                dataOutputStream.writeUTF("Access denied");
                socket.close();
            } else {
                System.out.println("Client password accepted.");
                dataOutputStream.writeUTF("Access granted");
            }
        }
    }
}