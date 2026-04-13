import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36640_SocketServer_A03 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(5);
        startServer();
    }

    private static void startServer() {
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                    System.out.println("Server closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_36640_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Here you can add your security-sensitive operations related to A03_Injection
                // For example, you can use PreparedStatements or ParameterizedQueries for SQL injection
                // writer.println("Echo: " + message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}