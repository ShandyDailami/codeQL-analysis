import java.io.*;
import java.net.*;

public class java_41703_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Listening for client on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            String response = "Server response to client's request: " + request;
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();

            socket.close();
        }
    }
}