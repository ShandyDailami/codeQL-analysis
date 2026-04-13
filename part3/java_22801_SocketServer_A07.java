import java.io.*;
import java.net.*;

public class java_22801_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                socket = server.accept();
                System.out.println("New client connected");

                // Create InputStream and OutputStream
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Receive username and password from client
                String username = dis.readUTF();
                String password = dis.readUTF();

                // Hardcoded username and password
                if (username.equals("admin") && password.equals("password")) {
                    dos.writeUTF("Access granted");
                } else {
                    dos.writeUTF("Access denied");
                }

                dos.close();
                dis.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}