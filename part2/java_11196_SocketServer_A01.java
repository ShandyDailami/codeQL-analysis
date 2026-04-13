import java.io.*;
import java.net.*;

public class java_11196_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            dataOutputStream.writeUTF("HTTP/1.1 200 OK\r\n\r\n" + request);
            dataOutputStream.flush();

            socket.close();
        }
    }
}