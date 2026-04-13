import java.io.*;
import java.net.*;

public class java_17833_SocketServer_A07 {

    private static final String PASSWORD = "securePassword";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientPassword = dataInputStream.readUTF();

            if (!clientPassword.equals(PASSWORD)) {
                System.out.println("Authentication failed. Closing connection with client " + socket.getInetAddress().getHostAddress());
                dataOutputStream.writeUTF("Authentication failed");
                dataOutputStream.flush();
                socket.close();
                continue;
            }

            System.out.println("Authentication successful. Sending a message to client " + socket.getInetAddress().getHostAddress());
            dataOutputStream.writeUTF("Hello, client");
            dataOutputStream.flush();

            socket.close();
        }
    }
}