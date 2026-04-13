import java.io.*;
import java.net.*;

public class java_19172_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                if ("close".equals(message)) {
                    System.out.println("Closing connection with the client");
                    socket.close();
                    break;
                }

                out.writeUTF("Hello, client!");
                System.out.println("Sent message: " + out.writeUTF("Hello, client!"));
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}