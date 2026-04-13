import java.io.*;
import java.net.*;

public class java_41212_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Message received: " + message);

            dataOutputStream.writeUTF("Thank you for connecting to the server");
            dataOutputStream.flush();
            socket.close();
        }
    }
}