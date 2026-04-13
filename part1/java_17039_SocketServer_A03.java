import java.io.*;
import java.net.*;

public class java_17039_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read from the client
            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Echo back to the client
            out.writeUTF("Hello, client, you connected with IP: " + socket.getRemoteSocketAddress());
            out.flush();
        }
    }
}