import java.io.*;
import java.net.*;

public class java_01276_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            output.writeUTF("Message received: " + message);
            output.flush();

            socket.close();
        }
    }
}