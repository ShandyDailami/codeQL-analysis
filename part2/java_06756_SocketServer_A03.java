import java.io.*;
import java.net.*;

public class java_06756_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                if (message.contains("injection")) {
                    System.out.println("Injection detected");
                }

                out.writeUTF("Hello, client!");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}