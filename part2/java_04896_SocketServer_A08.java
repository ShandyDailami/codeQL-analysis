import java.io.*;
import java.net.*;

public class java_04896_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to client " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Request: " + request);

            String response = "Hello, client";
            dos.writeUTF(response);
            System.out.println("Response: " + response);

            socket.close();
        }
    }
}