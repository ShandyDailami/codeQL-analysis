import java.io.*;
import java.net.*;

public class java_31606_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String message = input.readUTF();
        System.out.println("Received: " + message);

        String response = "Hello Client!";
        output.writeUTF(response);
        System.out.println("Sent: " + response);

        socket.close();
    }
}