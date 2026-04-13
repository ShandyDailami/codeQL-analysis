import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06457_SocketServer_A03 {
    private static ExecutorService executor;
    private static Socket socket;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer(5000);
    }

    public static void startServer(int port) {
        executor = Executors.newCachedThreadPool();
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);
            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                handleClient(socket);
            }
        } catch (IOException e) {
            System.err.println("Server failed to start");
            System.exit(-1);
        }
    }

    public static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_06457_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            closeConnection();
        }
    }

    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // perform the necessary security-sensitive operations here
                // e.g., message = secureOperation(message);
                // send the message back to the client
                writer.println(message);
            }
        } catch (IOException e) {
            closeConnection();
        }
    }

    public void closeConnection() {
        try {
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            // handle exception
        }
    }
}