import java.net.*;
import java.io.*;

public class java_34110_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Request: " + request);

            dataOutputStream.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress());
            dataOutputStream.flush();
       
            socket.close();
        }
    }
}