import java.io.*;
import java.net.*;

public class java_04133_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client is connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received from client: " + clientMessage);

            String serverMessage = "Hello, client!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Sent to client: " + serverMessage);

            socket.close();
       
        }
    }
}