import java.io.*;
import java.net.*;

public class java_00195_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Handshake
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Server says: Hello, Client!";
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();
       
            socket.close();
        }
    }
}