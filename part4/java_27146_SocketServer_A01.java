import java.io.*;
import java.net.*;

public class java_27146_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received: " + clientMessage);

            if (clientMessage.equals("deny access")) {
                dataOutputStream.writeUTF("Access Denied");
            } else {
                dataOutputStream.writeUTF("Access Granted");
            }

            dataOutputStream.close();
            socket.close();
        }
    }
}