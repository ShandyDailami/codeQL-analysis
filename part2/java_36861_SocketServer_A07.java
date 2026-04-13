import java.io.*;
import java.net.*;

public class java_36861_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Authentication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientName = in.readUTF();
            System.out.println("Client name: " + clientName);

            String serverName = socket.getLocalSocketAddress().toString();
            System.out.println("Server name: " + serverName);

            // Compare client and server names for authentication
            if (clientName.equals(serverName)) {
                out.writeUTF("Authentication successful");
                out.writeUTF("Connection established");
            } else {
                out.writeUTF("Authentication failed");
           
            }

            out.close();
            in.close();
            socket.close();
        }
    }
}