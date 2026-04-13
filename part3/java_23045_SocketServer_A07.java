import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23045_SocketServer_A07 {
    private final ExecutorService exec = Executors.newCachedThreadPool();
    private final static String AUTH_OK = "AUTH_OK";
    private final static String AUTH_FAILURE = "AUTH_FAILURE";

    private String authUser = "user";
    private String authPass = "pass";

    public void startServer(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server started on port " + port);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());
                handleClient(socket);
            } catch (Exception e) {
                System.out.println("Exception occurred when handling client " + e);
                continue;
            }
        }
    }

    private void handleClient(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            System.out.println("Received message from client: " + clientMsg);

            String serverMsg = AUTH_OK;
            if (!clientMsg.equals(authUser) || !clientMsg.equals(authPass)) {
                serverMsg = AUTH_FAILURE;
            }

            out.writeUTF(serverMsg);
            out.flush();

            socket.close();
        } catch (IOException e) {
            System.out.println("Exception occurred when handling client " + e);
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.startServer(8080);
    }
}