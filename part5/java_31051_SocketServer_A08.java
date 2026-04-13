import java.io.*;
import java.net.*;

public class java_31051_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(3333);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

            while (true) {
                socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}