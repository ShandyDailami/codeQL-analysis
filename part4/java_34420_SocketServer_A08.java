import java.io.*;
import java.net.*;

public class java_34420_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(5000); // listen on port 5000
            System.out.println("Waiting for a client on port 5000...");

            socket = serverSocket.accept(); // wait for client
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF(); // read message from client
            System.out.println("Received: " + message);

            out.writeUTF("Server received your message"); // write message to client
            out.flush();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}