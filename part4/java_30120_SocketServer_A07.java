import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30120_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                // Here you can use a different thread for each client
                // ServerThread thread = new ServerThread(socket);
                // thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            System.out.println("Server is closed");
        }
    }
}