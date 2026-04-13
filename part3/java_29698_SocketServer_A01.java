import java.io.*;
import java.net.*;

public class java_29698_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Request: " + request);

            if (request.equals("BAN")) {
                out.writeUTF("Access Denied");
            } else {
                out.writeUTF("Access Granted");
            }

            socket.close();
        }
    }
}