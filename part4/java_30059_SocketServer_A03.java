import java.io.*;
import java.net.*;

public class java_30059_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello, World!");
            outputStream.flush();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Client says: " + inputStream.readUTF());
            socket.close();
       
        }
    }
}