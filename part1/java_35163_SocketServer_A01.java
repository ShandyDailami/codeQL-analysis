import java.io.*;
import java.net.*;

public class java_35163_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);

        while (true) {
            Socket socket = server.accept();

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read username
            String username = in.readUTF();

            // send greeting to the client
            out.writeUTF("Hello, " + username);

            // close the connection
            out.close();
            in.close();
        }
    }
}