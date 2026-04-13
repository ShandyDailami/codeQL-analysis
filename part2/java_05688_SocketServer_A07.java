import java.io.*;
import java.net.*;

public class java_05688_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server started on port: 1234");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Assume that the client is authenticated by providing a username.
            String username = in.readUTF();

            if ("admin".equals(username)) {
                out.writeUTF("Hello, " + username + ". You are authenticated!");
            } else {
                out.writeUTF("You are not authenticated!");
           
                socket.close();
            }

            out.close();
            in.close();

        }
    }
}