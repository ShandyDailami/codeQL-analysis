import java.io.*;
import java.net.*;

public class java_13538_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("Server started at port 9999");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Send handshake message
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Hello Client, You are connected to Server");

            // Receive handshake message
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String message = dis.readUTF();
            System.out.println("Server says: " + message);

            // Close the connection
            socket.close();
       
        }
    }
}