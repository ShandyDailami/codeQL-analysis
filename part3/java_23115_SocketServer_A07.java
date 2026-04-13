import java.net.*;
import java.io.*;

public class java_23115_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 4445;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("exit")) {
                    socket.close();
                } else {
                    out.writeUTF("Hello client, you connected successfully!");
                    out.flush();
                }
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