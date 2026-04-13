import java.io.*;
import java.net.*;
import java.util.*;

public class java_26082_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(args[0]);
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String randomValueServer = in.readUTF();
            String randomValueClient = UUID.randomUUID().toString();
            out.writeUTF(randomValueClient);

            if (randomValueServer.equals(randomValueClient)) {
                System.out.println("Handshake successful");
            } else {
                System.out.println("Handshake failed");
                socket.close();
            }
        }
    }
}