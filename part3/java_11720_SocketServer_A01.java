import java.io.*;
import java.net.*;

public class java_11720_SocketServer_A01 {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Connected to client");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello client!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}