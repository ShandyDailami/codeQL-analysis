import java.io.*;
import java.net.*;

public class java_17799_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String welcomeMessage = "Welcome to the server!";
            outputStream.writeUTF(welcomeMessage);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String message = inputStream.readUTF();
            System.out.println("Client says: " + message);

            socket.close();
        }
    }
}