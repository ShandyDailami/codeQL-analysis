import java.io.*;
import java.net.*;

public class java_18148_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started. Listening on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            if ("error".equals(clientMessage)) {
                out.writeUTF("Error: Attempted injection");
            } else {
                out.writeUTF("Server says: Hello, " + clientMessage);
            }

            socket.close();
        }
    }
}