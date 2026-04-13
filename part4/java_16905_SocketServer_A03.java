import java.io.*;
import java.net.*;

public class java_16905_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Client says: " + request);

            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);
       
            socket.close();
        }
    }
}