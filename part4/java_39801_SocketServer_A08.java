import java.io.*;
import java.net.*;

public class java_39801_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Message received");
                System.out.println("Sent: Message received");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}