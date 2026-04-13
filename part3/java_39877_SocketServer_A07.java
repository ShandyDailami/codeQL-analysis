import java.io.*;
import java.net.*;
import java.util.*;

public class java_39877_SocketServer_A07 {
    private static final int port = 1234;
    private static boolean running = true;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (running) {
                Socket socket = server.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("auth")) {
                    out.writeUTF("OK");
                    out.flush();
                } else {
                    out.writeUTF("FAIL");
                    out.flush();
                }

                socket.close();
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}