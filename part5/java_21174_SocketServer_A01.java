import java.io.*;
import java.net.*;

public class java_21174_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF();
            System.out.println("Client message: " + clientMsg);

            String serverMsg = "Server says: Hello " + clientMsg;
            dos.writeUTF(serverMsg);

            dos.close();
            dis.close();
            socket.close();

            System.out.println("Client disconnected");
        }
    }
}