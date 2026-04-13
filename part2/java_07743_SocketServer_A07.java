import java.io.*;
import java.net.*;

public class java_07743_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            dos.writeUTF("Hello, client, you are authenticated");
            dos.flush();
       
            socket.close();
        }
    }
}