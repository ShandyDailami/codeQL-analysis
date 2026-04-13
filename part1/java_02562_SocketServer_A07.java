import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_02562_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class Handler implements Runnable {
    private Socket socket;

    public java_02562_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Get the client's IP
            InetAddress address = socket.getInetAddress();

            // Send the client's IP to the client
            out.println("Server: " + address.getHostAddress());

            // Read the message from the client
            String message = in.readLine();
            System.out.println("Client: " + message);

            // Close the streams and the socket
            out.close();
            in.close();
            socket.close();

            System.out.println("Client " + address.getHostAddress() + " disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}