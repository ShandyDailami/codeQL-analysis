import java.io.*;
import java.net.*;

public class java_11158_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);

        while (true) {
            Socket socket = server.accept();

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Client says: " + message);

            if ("exit".equals(message)) {
                break;
            }

            message = "Hello, client!";
            output.writeUTF(message);
       
            output.close();
            input.close();
            socket.close();
        }

        server.close();
    }
}