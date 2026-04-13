import java.io.*;
import java.net.*;

public class java_13039_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Server Message";
    private static final int PORT = 8080;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client accepted: " + socket.getRemoteSocketAddress());

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF(SERVER_MESSAGE);

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println("Client says: " + inputStream.readUTF());

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}