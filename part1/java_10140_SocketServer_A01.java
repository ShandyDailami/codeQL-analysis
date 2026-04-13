import java.io.*;
import java.net.*;

public class java_10140_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            dataOutputStream.writeUTF("Message received");
            dataOutputStream.flush();

            socket.close();
       
        }
    }
}