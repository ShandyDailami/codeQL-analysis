import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29798_SocketServer_A08 {
    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        int port = 8080;
        startServer(port);
    }

    public static void startServer(int port) throws Exception {
        executorService = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            System.out.println("Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread to handle communication with the client
            executorService.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_29798_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html;charset=utf-8");
                    out.println("Content-Length: 13");
                    out.println();
                    out.println("<h1>Hello, this is a test</h1>");
                }

                out.close();
                in.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}