import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33099_SocketServer_A08 {
    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Connection accepted from " + client.getRemoteSocketAddress());
                pool.execute(new RequestHandler(client));
            } catch (Exception e) {
                System.out.println("Exception encountered while handling connection. " + e);
           .
            }
        }
    }

    static class RequestHandler implements Runnable {
        Socket client;

        RequestHandler(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    out.println("Received your request. Thank you! You have been authenticated.");
                }

                client.close();
            } catch (IOException e) {
                System.out.println("Exception encountered while handling connection. " + e);
            }
        }
    }
}