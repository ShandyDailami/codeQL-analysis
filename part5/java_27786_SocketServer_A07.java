import java.io.*;
import java.net.*;

public class java_27786_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String clientMessage;
        while ((clientMessage = input.readUTF()) != null) {
            System.out.println("Received: " + clientMessage);

            if (clientMessage.equals("auth")) {
                output.writeUTF("Auth successful!");
            } else {
                output.writeUTF("Auth failed!");
            }
            output.flush();
        }

        socket.close();
        server.close();
    }
}