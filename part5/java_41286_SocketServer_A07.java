import java.io.*;
import java.net.*;
import java.util.*;

public class java_41286_SocketServer_A07 {

    private static final String SERVER_MESSAGE = "Hello, you are authenticated!";
    private static final String CLIENT_MESSAGE = "Hello, I am a client!";
    private static final int PORT = 4444;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            if (message.equals(CLIENT_MESSAGE)) {
                out.writeUTF(SERVER_MESSAGE);
                out.flush();
            } else {
                out.writeUTF("Authentication failure!");
                out.flush();
            }

            clientSocket.close();
        }
    }
}