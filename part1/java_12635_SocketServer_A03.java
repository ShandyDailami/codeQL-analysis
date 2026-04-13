import java.io.*;
import java.net.*;

public class java_12635_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            out.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress());
            socket.close();
        }
    }
}