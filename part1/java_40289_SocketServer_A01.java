import java.io.*;
import java.net.*;

public class java_40289_SocketServer_A01 {

    private static int serverPort = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started on port " + serverPort);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent message: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}