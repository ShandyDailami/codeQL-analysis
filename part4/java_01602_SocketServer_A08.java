import java.io.*;
import java.net.*;

public class java_01602_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at port: " + 8000);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello from server!";
            dataOutputStream.writeUTF(serverMessage);

            socket.close();
        }
    }
}