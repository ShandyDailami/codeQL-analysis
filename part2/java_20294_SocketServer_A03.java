import java.io.*;
import java.net.*;
import java.util.*;

public class java_20294_SocketServer_A03 {

    private static int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Sending a response to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Welcome to secure server!");

            // Close the connection
            socket.close();
        }
    }
}