import java.io.*;
import java.net.*;

public class java_32730_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                System.out.println("Exiting connection from " + socket.getRemoteSocketAddress());
                break;
            } else {
                out.writeUTF("Hello, client, message received successfully.");
                out.flush();
            }

            socket.close();
        }

        serverSocket.close();
    }
}