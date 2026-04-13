import java.io.*;
import java.net.*;

public class java_40189_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Message received: " + message);

            if (message.equals("Auth")) {
                dos.writeUTF("AuthSuccess");
            } else {
                dos.writeUTF("AuthFailure");
            }

            dos.flush();
            client.close();
        }
    }
}