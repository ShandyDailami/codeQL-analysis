import java.io.*;
import java.net.*;

public class java_28518_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for a client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Server says: Hello, Client!";
        dataOutputStream.writeUTF(serverMessage);

        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
        server.close();
    }
}