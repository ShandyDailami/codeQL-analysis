import java.io.*;
import java.net.*;

public class java_32490_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received: " + clientMessage);

            String responseMessage = "Hello, Client!";
            output.writeUTF(responseMessage);
            System.out.println("Sent: " + responseMessage);

            socket.close();
        }
    }
}