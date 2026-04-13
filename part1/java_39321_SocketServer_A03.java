import java.net.*;
import java.io.*;

public class java_39321_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port: 12345");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);
                String serverMessage = "Server says: Hello, " + clientMessage;
                out.writeUTF(serverMessage);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}