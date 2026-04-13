import java.io.*;
import java.net.*;

public class java_35851_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);
            System.out.println("Response sent: " + response);

            socket.close();
        }
    }
}