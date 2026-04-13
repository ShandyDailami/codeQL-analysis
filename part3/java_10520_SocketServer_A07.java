import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10520_SocketServer_A07 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected " + socket.getRemoteSocketAddress());

                // Here you can create separate threads for each client, for multi-threaded server
                // new ServerThread(socket).start();

                // For simplicity, we are just accepting connections and closing them immediately
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}