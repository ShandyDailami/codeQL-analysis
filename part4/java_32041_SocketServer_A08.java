import java.io.*;
import java.net.*;

public class java_32041_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("exit")) {
                break;
            }

            out.writeUTF("Hello, client! Message received.");
            out.flush();
        }

        server.close();
    }
}