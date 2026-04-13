import java.io.*;
import java.net.*;

public class java_19824_SocketServer_A03 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(6789); // port number
            System.out.println("Waiting for a client on port " + serverSocket.getLocalPort() + "...");

            // accept a socket connection
            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // receive and echo back the message
            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Echo: " + message);
            System.out.println("Sent: " + message);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}