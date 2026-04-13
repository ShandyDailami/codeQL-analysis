import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32364_SocketServer_A08 {
    private static final int port = 8080;
    private static final String ip = "127.0.0.1";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket(port, 1000, InetAddress.getByName(ip))) {
            System.out.println("Server started on port " + port + " with IP " + ip);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection");
        } finally {
            executor.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_32364_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream out = socket.getOutputStream();
             InputStream in = socket.getInputStream()) {
            byte[] bytes = new byte[1024];
            int length;
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
        } catch (IOException ex) {
            System.out.println("Error handling client");
        }
    }
}