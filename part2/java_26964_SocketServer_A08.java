import java.io.*;
import java.net.*;

public class java_26964_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);

        while (true) {
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            out.flush();
       
            socket.close();
        }
    }
}