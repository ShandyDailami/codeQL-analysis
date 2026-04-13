import java.io.*;
import java.net.*;

public class java_09367_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started at port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF();
            System.out.println("Received: " + message);

            outputStream.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            outputStream.flush();

            socket.close();
       
        }
    }
}