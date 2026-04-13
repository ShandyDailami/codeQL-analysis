import java.io.*;
import java.net.*;

public class java_27925_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket client = server.accept();
            System.out.println("A client has connected");

            // SEND
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Server response to client");

            // RECIEVE
            DataInputStream in = new DataInputStream(client.getInputStream());
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            client.close();
        }
    }
}