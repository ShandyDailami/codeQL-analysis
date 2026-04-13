import java.net.*;
import java.io.*;

public class java_26450_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Waiting for client on port " + 
                            serverSocket.getLocalPort() + "...");

        Socket socket = serverSocket.accept();

        System.out.println("Connected to " + 
                            socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();
        System.out.println("Client says: " + message);

        String response = "Hello, Client!";
        out.writeUTF(response);

        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}