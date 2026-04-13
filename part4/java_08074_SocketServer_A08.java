import java.net.*;
import java.io.*;

public class java_08074_SocketServer_A08 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientIdentifier = in.readUTF();

            if (clientIdentifier.equals(CLIENT_IDENTIFIER)) {
                out.writeUTF("Connection accepted");
            } else {
                out.writeUTF("Connection rejected");
           
            }

            clientSocket.close();
        }
    }
}