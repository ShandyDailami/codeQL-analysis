import java.io.*;
import java.net.*;

public class java_29893_SocketServer_A07 {

    private static final int PORT = 12345;
    private static Socket socket;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);
            socket = server.accept();
            System.out.println("A client has connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Client says: " + message);

            output.writeUTF("Server says: Hello, client!");
            output.flush();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}