import java.io.*;
import java.net.*;

public class java_09000_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080); // listen on port 8080
            while (true) {
                Socket socket = server.accept(); // wait for a client to connect
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read the message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // send the message back to the client
                out.writeUTF("Server: " + message);
                out.flush();

                socket.close(); // close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}