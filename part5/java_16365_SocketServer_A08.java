import java.io.*;
import java.net.*;

public class java_16365_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = inputStream.readUTF()) != null) {
                System.out.println("Received: " + clientMessage);
                outputStream.writeUTF("Server says: " + clientMessage);
                outputStream.flush();
           
            }
            socket.close();
        }
    }
}