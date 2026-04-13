import java.io.*;
import java.net.*;

public class java_04334_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, " + clientMessage + "!";
            out.writeUTF(serverMessage);
            out.flush();

            socket.close();
        }
    }
}