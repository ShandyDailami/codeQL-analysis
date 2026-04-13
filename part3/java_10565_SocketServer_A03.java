import java.io.*;
import java.net.*;

public class java_10565_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Thank you for connecting!";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening on port: " + 8080);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientRequest = in.readUTF();
            System.out.println("Client says: " + clientRequest);

            // Here we handle the request and potentially inject an SQL command
            // This is a simple example where we just echo back the request
            String serverResponse = clientRequest;

            out.writeUTF(serverResponse);
            out.flush();

            clientSocket.close();
       
        }

    }

}