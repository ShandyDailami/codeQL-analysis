import java.io.*;
import java.net.*;

public class java_15008_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started... Listening for client connections on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientQuery = dataInputStream.readUTF();

            System.out.println("Received query: " + clientQuery);

            if (clientQuery.equals("close")) {
                dataOutputStream.writeUTF("Server closed successfully");
                dataOutputStream.flush();
                socket.close();
                serverSocket.close();
            } else {
                dataOutputStream.writeUTF("Invalid query, please provide valid query");
                dataOutputStream.flush();
            }

            System.out.println("Sent response back to client");
        }
    }
}