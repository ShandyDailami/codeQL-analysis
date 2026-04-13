import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36281_SocketServer_A07 {

    private static ExecutorService executor;
    private static int port;

    public static void main(String[] args) {
        port = 6000; // default port

        // if command line arguments were provided, use them
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        executor = Executors.newFixedThreadPool(10);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                // start a new thread to handle the client request
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_36281_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // for simplicity, we're going to check if the request is "auth"
                    // in a real world application, you would want to store the hash of the password instead
                    if ("auth".equalsIgnoreCase(request)) {
                        writer.println("200 OK"); // authentication successful
                    } else {
                        writer.println("401 Unauthorized"); // authentication failed
                    }

                    writer.flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}