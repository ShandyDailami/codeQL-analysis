import java.io.*;
import java.net.*;

public class java_05431_SocketServer_A01 {

    public static void main(String args[]) {
        Socket socket;

        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client connection...");

            socket = serverSocket.accept();

            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            OutputStream outToClient = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToClient);

            // send a simple message to the client
            out.writeUTF("Welcome to the server! You are connected to port " + 4444);

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}