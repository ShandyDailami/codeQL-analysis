import java.io.*;
import java.net.*;

public class java_05217_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started at port: 5000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, " + clientMessage + "!";
            out.writeUTF(serverMessage);
            out.flush();

            socket.close();
        }
    }
}