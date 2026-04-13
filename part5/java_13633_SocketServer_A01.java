import java.io.*;
import java.net.*;

public class java_13633_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we're using DataOutputStream for sending responses
            // But in real-world applications, you would want to use a more secure method, like SSL/TLS
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello, client, you are authenticated!");
            outputStream.close();

            socket.close();
        }
    }
}