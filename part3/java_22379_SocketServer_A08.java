import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22379_SocketServer_A08 {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                // Here you can use a thread per client model
                // new ServerThread(client).start();

                // Or a single thread model using executors
                // ExecutorService executor = Executors.newSingleThreadExecutor();
                // executor.execute(new ServerThread(client));
                // executor.shutdown();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}