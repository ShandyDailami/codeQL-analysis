import java.io.*;
import java.net.*;

public class java_19134_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received message: " + clientMessage);

                String serverMessage = "Server Echo: " + clientMessage;
                dataOutputStream.writeUTF(serverMessage);
                System.out.println("Sent message: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}