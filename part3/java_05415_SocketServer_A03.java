import java.io.*;
import java.net.*;

public class java_05415_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888); // create a server socket on port 8888
        System.out.println("Waiting for connection on port 8888...");

        while (true) {
            Socket socket = server.accept(); // accept a connection
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // send reply
            out.writeUTF("Server received: " + message);
            out.flush();

            // close the connection
            socket.close();
        }
    }
}