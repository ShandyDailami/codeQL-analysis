import java.io.*;
import java.net.*;

public class java_00370_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected...");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Message received from client: " + message);

                out.writeUTF("Hello, client!");
                System.out.println("Message sent to client...");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}