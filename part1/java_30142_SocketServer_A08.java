import java.io.*;
import java.net.*;

public class java_30142_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected: " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String messageFromClient = in.readUTF();
                System.out.println("Client says: " + messageFromClient);

                String response = "Hello, client, thanks for connecting!";
                out.writeUTF(response);
                System.out.println("Server says: " + response);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}