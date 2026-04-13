import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29799_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server on port " + PORT);
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            try {
                System.out.println("Waiting for connection...");
                Socket client = server.accept();
                System.out.println("Connected to: " + client.getRemoteSocketAddress());

                HandleClient clientHandler = new HandleClient(client);
                executor.execute(clientHandler);
            } catch (IOException ex) {
                System.out.println("IOException from client.");
                break;
            }
        }

        server.close();
        executor.shutdown();
    }

    private static class HandleClient implements Runnable {
        private final Socket clientSocket;

        public java_29799_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);

                InputStream in = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    if (clientMessage.equals("exit")) {
                        writer.println("Exiting");
                        break;
                    }

                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: text/html; charset=utf-8");
                    writer.println();
                    writer.println("<h1>Hello, World!</h1>");
                    writer.println();
                }

                clientSocket.close();
            } catch (IOException ex) {
                System.out.println("IOException in client handler.");
            }
        }
    }
}