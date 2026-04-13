import java.io.*;
import java.net.*;

public class java_13378_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Server says: Hello, client!";
            dos.writeUTF(serverMessage);
            dos.flush();

            socket.close();
        }
    }
}