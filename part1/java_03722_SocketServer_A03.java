import java.net.*;
import java.io.*;

public class java_03722_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if (request.equals("bomb")) {
                out.writeUTF("You are under attack!");
                System.out.println("Bomb planted!");
            } else {
                out.writeUTF("Unknown command");
            }

            out.close();
            socket.close();
       
        }
    }
}