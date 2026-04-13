import java.io.*;
import java.net.*;

public class java_00910_SocketServer_A01 {

    private static int port = 8080;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String message = inputStream.readUTF();
                System.out.println("Client says: " + message);

                outputStream.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}