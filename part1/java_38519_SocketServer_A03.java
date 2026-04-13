import java.io.*;
import java.net.*;

public class java_38519_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Reading data from client
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();

            System.out.println("Received message from client: " + clientMessage);

            // Security-sensitive operations related to A03_Injection
            // Here, we are simply echoing the client's message back to the client
            String serverMessage = clientMessage;

            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();

            System.out.println("Sent message to client: " + serverMessage);

            socket.close();
        }
    }
}