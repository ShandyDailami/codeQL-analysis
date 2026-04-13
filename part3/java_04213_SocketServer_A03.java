import java.io.*;
import java.net.*;

public class java_04213_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received message: " + clientMessage);

                String responseMessage = "Hello, client!";
                dataOutputStream.writeUTF(responseMessage);
                System.out.println("Sent message: " + responseMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}