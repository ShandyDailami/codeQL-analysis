import java.io.*;
import java.net.*;

public class java_06674_SocketServer_A07 {
    private static final int port = 8080;
    private static boolean stopServer = false;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (!stopServer) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Message received: " + message);

            String response = "Hello client, your message was received!";
            dos.writeUTF(response);

            socket.close();
        }

        serverSocket.close();
    }
}