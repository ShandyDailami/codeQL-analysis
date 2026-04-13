import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41249_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Hello Client, You are connected to the server!";
    private static final int SERVER_PORT = 8080;

    private static ExecutorService executor;
    private static BlockingQueue<Socket> queue;

    public static void main(String[] args) {
        // Initialize the ExecutorService and the BlockingQueue
        executor = Executors.newFixedThreadPool(5);
        queue = new LinkedBlockingQueue<Socket>(10);

        // Start the server
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                queue.put(socket);
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_41249_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Send a message to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(SERVER_MESSAGE);

                // Receive a message from the client
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String input = in.readLine();
                System.out.println("Client says: " + input);

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}