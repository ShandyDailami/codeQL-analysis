import java.io.*;
import java.net.*;

public class java_27636_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final String QUERY_STRING = "name=";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started with port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String query = in.readUTF(); // read query string from client

                // use query string to perform injection attack
                String userInput = QUERY_STRING + query;
                out.writeUTF(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}