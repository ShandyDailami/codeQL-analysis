import java.io.*;
import java.net.*;

public class java_22471_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = "Server received your message: " + clientMessage;
            dos.writeUTF(serverMessage);
            dos.flush();
       
            socket.close();
        }
    }
}