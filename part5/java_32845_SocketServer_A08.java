import java.io.*;
import java.net.*;

public class java_32845_SocketServer_A08 {

    private static final String SERVER_MESSAGE = "Hello, client!";
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF(SERVER_MESSAGE);

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client message: " + clientMessage);

                clientSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}