import java.io.*;
import java.net.*;

public class java_27251_SocketServer_A01 {

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client on port 4444");

            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());

            String message = inFromClient.readUTF();
            System.out.println("Received: " + message);

            outToClient.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            outToClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}