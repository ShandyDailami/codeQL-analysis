import java.net.*;
import java.io.*;

public class java_22431_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6789);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

            Socket socket = server.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello Client!";
            out.writeUTF(response);
            System.out.println("Server says: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}