import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class java_34691_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final String SERVER_STATUS = "SERVER_STATUS";
    private static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            clients.add(writer);

            String clientMessage = "CLIENT_MESSAGE: Your ID is " + socket.getLocalSocketAddress();
            writer.println(clientMessage);

            broadcast(clientMessage);
        }
    }

    private static void broadcast(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
        }
    }
}