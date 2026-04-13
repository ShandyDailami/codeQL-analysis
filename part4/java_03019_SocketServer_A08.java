import java.io.*;
import java.net.*;

public class java_03019_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        int port = 12345;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            String response = "Response: " + request;
            out.writeUTF(response);
            System.out.println("Sent response: " + response);

            socket.close();
        }
    }
}