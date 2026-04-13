import java.io.*;
import java.net.*;

public class java_15290_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("auth")) {
                output.writeUTF("Auth successful");
            } else {
                output.writeUTF("Auth failure");
           
            }

            socket.close();
        }
    }
}