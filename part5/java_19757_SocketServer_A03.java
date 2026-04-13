import java.io.*;
import java.net.*;

public class java_19757_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Echo: " + message);
            out.flush();

            socket.close();
        }
    }
}