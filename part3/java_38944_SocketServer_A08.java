import java.io.*;
import java.net.*;

public class java_38944_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = "Thank you for connecting to the server";
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}