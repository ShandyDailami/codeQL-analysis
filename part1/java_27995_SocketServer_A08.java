import java.io.*;
import java.net.*;

public class java_27995_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket socket = server.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            String message = input.readUTF();
            System.out.println("Client says: " + message);
            String response = "Hello, client!";
            output.writeUTF(response);
            socket.close();
        }
    }
}