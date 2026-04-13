import java.io.*;
import java.net.*;

public class java_13778_SocketServer_A01 {
    private static final String SERVER_STATUS = "Server Started";
    private static final String CLIENT_STATUS = "Client Connected";

    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server Started: " + port);

        while (true) {
            System.out.println("Waiting for Client on Port: " + port);
            Socket socket = serverSocket.accept();

            System.out.println(CLIENT_STATUS);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received Client Message: " + clientMessage);

            if (clientMessage.equals("access")) {
                out.writeUTF(SERVER_STATUS);
                out.flush();
            } else {
                out.writeUTF(CLIENT_STATUS);
                out.flush();
            }

            socket.close();
        }
    }
}