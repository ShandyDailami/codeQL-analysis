import java.io.*;
import java.net.*;

public class java_01469_SocketServer_A08 {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(2444); // port number
            System.out.println("Waiting for client on port " +
                    serverSocket.getLocalPort() + "...");

            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Received: " + message);

                // Echo the message back to the client
                out.writeUTF(message);
                out.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}