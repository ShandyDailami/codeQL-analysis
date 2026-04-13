import java.net.*;
import java.io.*;

public class java_01129_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected!");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Reading from the client
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received Message: " + clientMessage);

            // Sending a response
            String serverMessage = "Hello Client, You Connected!";
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();
       
            socket.close();
        }
    }
}