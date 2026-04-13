import java.io.*;
import java.net.*;

public class java_16604_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established!");

            socket.close();
        }
    }
}