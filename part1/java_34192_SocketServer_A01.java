import java.net.*;
import java.io.*;

public class java_34192_SocketServer_A01 {
    public static void main(String args[]) {
        int port = 5000;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            socket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello Client, you connected to my server!";
            out.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}