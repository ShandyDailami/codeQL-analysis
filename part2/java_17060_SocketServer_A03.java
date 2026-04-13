import java.io.*;
import java.net.*;

public class java_17060_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Message received: " + message);

            output.writeUTF("Message received: " + message);
            output.flush();

            socket.close();
        }
    }
}