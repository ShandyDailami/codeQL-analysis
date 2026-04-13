import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_00472_SocketServer_A07 {
    private static ExecutorService executor;
    private static int port = 12345;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started at port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_00472_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                close(clientSocket, in, out);
                System.out.println("Error creating I/O streams");
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    if ("auth:username password".equals(request)) {
                        out.println("true"); // Authentication successful
                    } else {
                        out.println("false"); // Authentication failed
                    }
                    out.flush();
                }
            } catch (IOException e) {
                close(clientSocket, in, out);
                System.out.println("Error handling client");
            }
        }

        private static void close(Socket socket, BufferedReader in, PrintWriter out) {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket");
            }
        }
    }
}