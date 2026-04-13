import java.io.*;
import java.net.*;

public class java_02686_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String request = dataInputStream.readUTF();
                System.out.println("Request: " + request);

                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);

                dataOutputStream.close();
                dataInputStream.close();
                socket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}