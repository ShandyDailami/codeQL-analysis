import java.io.*;
import java.net.*;

public class java_05584_SocketServer_A08 {
    private static final String SERVER_MESSAGE = "Server is listening";
    private static final int PORT = 1234;
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                outToClient.writeUTF(SERVER_MESSAGE);

                DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
                System.out.println("Message from client: " + inFromClient.readUTF());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}