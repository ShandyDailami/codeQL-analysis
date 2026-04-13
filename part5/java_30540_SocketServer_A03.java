import java.io.*;
import java.net.*;

public class java_30540_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();

        System.out.println("Client accepted!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMessage;

        while ((clientMessage = in.readUTF()) != null) {
            System.out.println("Client says: " + clientMessage);

            if (clientMessage.equals("shutdown")) {
                System.out.println("Server shutting down...");
                out.writeUTF("Server shutting down...");
                socket.close();
                serverSocket.close();
                System.exit(0);
            } else {
                out.writeUTF("Server says: " + clientMessage);
            }
        }
    }
}