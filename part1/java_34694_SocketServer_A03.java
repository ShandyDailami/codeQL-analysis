import java.io.*;
import java.net.*;

public class java_34694_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Your unique code here

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            out.flush();
       
            socket.close();
        }
    }
}