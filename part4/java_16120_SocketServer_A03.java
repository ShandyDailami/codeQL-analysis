import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16120_SocketServer_A03 {

    private static final int PORT = 8080;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {

        // create executor service with a fixed thread pool of size 10
        executorService = Executors.newFixedThreadPool(10);

        // create server socket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        // infinite loop to accept client connections
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // create new thread for each client connection
                Handler handler = new Handler(socket);
                executorService.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // static inner class Handler for handling each client connection
    static class Handler extends Thread {

        private Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_16120_SocketServer_A03(Socket socket) {
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
            String request;
            try {
                while ((request = reader.readLine()) != null) {
                    // perform operation on client's request here
                    // this could be a security-sensitive operation like injection

                    // example: remove '<', '>', ';', '`', '{', '}', '(', ')', ':', '"'
                    request = request.replace('<', ' ').replace('>', ' ').replace(';', ' ').replace('`', ' ').replace('{', ' ').replace('}', ' ').replace('(', ' ').replace(')', ' ').replace(':', ' ').replace('"', ' ');

                    // send response back to client
                    writer.println("Response: " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}