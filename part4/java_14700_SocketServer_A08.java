import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class java_14700_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444); // Port Number
            System.out.println("Waiting for client on port 4444...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            String response = "Hello, client";
            dataOutputStream.writeUTF(response);

            System.out.println("Sent message: " + response);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}