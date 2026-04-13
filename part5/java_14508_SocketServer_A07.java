import java.io.*;
import java.net.*;

public class java_14508_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                out.writeUTF("Connection established");
            } else {
                out.writeUTF("Connection failed");
           
            }

            socket.close();
        }
    }
}