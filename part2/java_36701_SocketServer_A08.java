import java.io.*;
import java.net.*;

public class java_36701_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for connection on port: 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Client says: " + message);

            String responseMessage = "Hello, client!";
            dataOutputStream.writeUTF(responseMessage);

            socket.close();
       
        }
    }
}