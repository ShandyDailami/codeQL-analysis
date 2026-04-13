import java.io.*;
import java.net.*;

public class java_34243_SocketServer_A07 {
    private static int PORT = 5000;
    private static boolean runServer = true;

    public static void main(String[] args) {
        createServer();
    }

    private static void createServer() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (runServer) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Message from client: " + message);

                if (message.equals("exit")) {
                    runServer = false;
                } else {
                    dos.writeUTF("Hello Client, you are authenticated!");
                    dos.flush();
                }

                socket.close();
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}