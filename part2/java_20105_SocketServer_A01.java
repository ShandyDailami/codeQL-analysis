import java.io.*;
import java.net.*;

public class java_20105_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Client message: " + clientMessage);

            String serverMessage = "Server received your message: " + clientMessage;
            output.writeUTF(serverMessage);
            output.flush();

            socket.close();
        }
    }
}