import java.io.*;
import java.net.*;

public class java_06133_SocketServer_A08 {
    private static final String QUIT = "quit";
    private boolean stopped = false;

    public static void main(String[] args) {
        new SocketServerExample().run();
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Waiting for connection on port 8189...");

            while (!stopped) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
                handle(socket);
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handle(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while (!QUIT.equals((message = in.readUTF()))) {
                System.out.println("Received: " + message);
                out.writeUTF("Server says: " + message);
            }

            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}