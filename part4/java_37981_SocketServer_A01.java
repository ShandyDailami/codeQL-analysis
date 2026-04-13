import java.io.*;
import java.net.*;

public class java_37981_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                break;
            }

            String response = "Server says: Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }

        serverSocket.close();
    }
}