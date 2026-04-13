import java.io.*;
import java.net.*;

public class java_36561_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected.");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message from client: " + message);

            String response = "Hello, Client!";
            dataOutputStream.writeUTF(response);
            System.out.println("Sent response to client.");

            socket.close();
        }
    }
}