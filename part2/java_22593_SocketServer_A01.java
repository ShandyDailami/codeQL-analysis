import java.io.*;
import java.net.*;

public class java_22593_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("New client connected");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                String clientMessage;

                clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}