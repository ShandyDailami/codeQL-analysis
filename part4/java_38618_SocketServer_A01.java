import java.io.*;
import java.net.*;

public class java_38618_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started at port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Connection established");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientMessage = inputStream.readUTF();
            System.out.println("Received from client: " + clientMessage);

            socket.close();
       
        }
    }
}