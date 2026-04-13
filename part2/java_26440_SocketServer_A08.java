import java.io.*;
import java.net.*;

public class java_26440_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage;

        // read from client
        while ((clientMessage = dataInputStream.readUTF()) != null) {
            System.out.println("Received client message: " + clientMessage);

            // send to client
            dataOutputStream.writeUTF("Hello, client!");
            dataOutputStream.flush();
       
        }
        socket.close();
        server.close();
    }
}