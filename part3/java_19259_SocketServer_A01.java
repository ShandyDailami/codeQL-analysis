import java.io.*;
import java.net.*;

public class java_19259_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Received: " + request);

            String response = "Hello from server!";
            dataOutputStream.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}