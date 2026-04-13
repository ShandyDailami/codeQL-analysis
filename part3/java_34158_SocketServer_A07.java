import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34158_SocketServer_A07 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_34158_SocketServer_A07(int port) throws IOException {
        this.executor = Executors.newFixedThreadPool(10);
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        executor.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_34158_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if ("exit".equals(inputLine)) {
                        out.println("Goodbye!");
                        break;
                    } else {
                        out.println("Hello, " + inputLine);
                    }
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        VanillaJavaServer server = new VanillaJavaServer(8080);
        server.start();
    }
}