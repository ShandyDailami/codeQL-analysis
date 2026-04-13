import java.net.*;
import java.io.*;

public class java_10276_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received client message: " + clientMessage);

                // Here you can add code to perform security-sensitive operations related to A03_Injection
                // For example, by checking if the message contains a specific word or sequence of characters and replacing it if it does
                // Here we just echo the message back to the client
                dataOutputStream.writeUTF(clientMessage);

                dataOutputStream.close();
                dataInputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}