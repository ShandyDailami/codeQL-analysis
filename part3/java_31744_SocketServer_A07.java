import java.io.*;
import java.net.*;

public class java_31744_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            if (message.equals("AUTH")) {
                dataOutputStream.writeUTF("OK");
            } else {
                dataOutputStream.writeUTF("FAIL");
            }

            socket.close();
        }
    }
}