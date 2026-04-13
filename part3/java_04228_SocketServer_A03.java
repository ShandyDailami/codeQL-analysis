import java.io.*;
import java.net.*;

public class java_04228_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started. Waiting for client on port " + 8000);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello, client. You connected successfully.";
                dataOutputStream.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}