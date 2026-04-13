import java.io.*;
import java.net.*;

public class java_35606_SocketServer_A01 {

    public static void main(String[] args) {
        ServerSocket server = null;
        while (true) {
            try {
                server = new ServerSocket(1234);
                System.out.println("Waiting for client on port: " + server.getLocalPort() + "...");
                Socket socket = server.accept();
                System.out.println("Connected to: " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String clientMessage, serverMessage;
                clientMessage = in.readUTF();
                serverMessage = "Server: Hello, client!";
                out.writeUTF(serverMessage);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
       
        }
    }
}