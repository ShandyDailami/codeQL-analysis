import java.io.*;
import java.net.*;

public class java_04576_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();

            // This is a security-sensitive operation related to A03_Injection
            // It should be replaced with actual code that uses the request to perform some action
            String response = request.replace("<", "bad").replace(">", "bad");

            out.writeUTF("Server response: " + response);
            out.flush();

            socket.close();
        }
    }
}