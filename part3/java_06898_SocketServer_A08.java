import java.io.*;
import java.net.*;

public class java_06898_SocketServer_A08 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                if ("STOP".equalsIgnoreCase(message)) {
                    System.out.println("Server stopped");
                    socket.close();
                    server.close();
                    System.out.println("Connection closed");
                    break;
                } else {
                    out.writeUTF("Hello, Client!");
                    out.flush();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}