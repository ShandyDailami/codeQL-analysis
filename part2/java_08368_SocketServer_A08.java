import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08368_SocketServer_A08 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;
    private static boolean running = true;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");
            while (running) {
                try {
                    System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected on port " + clientSocket.getPort());
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    executor.execute(clientHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Failed to accept client connection on port " + serverSocket.getLocalPort());
                    System.exit(-1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server closed");
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final BufferedReader in;
    private final PrintWriter out;

    public java_08368_SocketServer_A08(Socket socket) {
        clientSocket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}