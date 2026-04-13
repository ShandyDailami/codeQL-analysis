import java.io.*;
import java.net.*;

public class java_16185_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received: " + clientMessage);

            // This is a security-sensitive operation
            String responseMessage = "Server response: " + clientMessage;
            output.writeUTF(responseMessage);
            output.flush();

            socket.close();
        }
    }
}