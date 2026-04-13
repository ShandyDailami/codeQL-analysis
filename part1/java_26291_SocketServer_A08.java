import java.io.*;
import java.net.*;

public class java_26291_SocketServer_A08 {
    private static final int PORT = 9999;
    private static Socket socket;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        startServer();
    }

    private static void startServer() throws IOException {
        server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            socket = server.accept();

            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("BYE")) {
                System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected.");
                socket.close();
            } else {
                output.writeUTF("Thank you for connecting");
                output.flush();
            }
        }
    }
}