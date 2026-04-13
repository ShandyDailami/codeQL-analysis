import java.io.*;
import java.net.*;

public class java_10411_SocketServer_A07 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("A07_AuthFailure")) {
                    out.writeUTF("AuthFailure");
                    out.flush();
                } else {
                    out.writeUTF("Unknown request");
                    out.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}