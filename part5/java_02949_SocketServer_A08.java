import java.net.*;
import java.io.*;

public class java_02949_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 1234;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                message = message.toUpperCase();
                out.writeUTF(message);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}