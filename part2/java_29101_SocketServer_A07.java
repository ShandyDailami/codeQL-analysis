import java.io.*;
import java.net.*;

public class java_29101_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            if (clientMessage.equals("auth fail")) {
                dataOutputStream.writeUTF("auth fail");
                dataOutputStream.flush();
            } else {
                dataOutputStream.writeUTF("success");
                dataOutputStream.flush();
            }

            socket.close();
        }
    }
}