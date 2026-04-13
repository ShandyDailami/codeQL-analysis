import java.net.*;
import java.io.*;

public class java_27899_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        int port = 4445;
        boolean listening = true;
        ServerSocket server = new ServerSocket(port);

        while (listening) {
            Socket connection = server.accept();
            System.out.println("Connection accepted from: " + connection.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(connection.getInputStream());
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + connection.getRemoteSocketAddress() + "!");
            connection.close();
       
        }
        server.close();
    }
}