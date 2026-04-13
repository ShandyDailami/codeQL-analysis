import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_38028_SocketServer_A07 {
    private static final int PORT = 6789;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            try (Socket socket = new Socket("localhost", PORT)) {
                executorService.execute(new ClientHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_38028_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the client here
        // for example, we can use a simple username/password system
        try {
            socket.getInputStream().read();
            socket.getOutputStream().write("Username:".getBytes());
            byte[] username = new byte[256];
            socket.getInputStream().read(username);
            socket.getOutputStream().write("Password:".getBytes());
            byte[] password = new byte[256];
            socket.getInputStream().read(password);
            // TODO: implement authentication logic
            // if authentication fails, send back a response
            // if authentication succeeds, send back a welcome message
            socket.getOutputStream().write("Welcome, ".concat(new String(username)).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}