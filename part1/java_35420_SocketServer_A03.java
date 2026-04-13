import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35420_SocketServer_A03 {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static int clientCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server Started...");

        while (true) {
            try {
                Socket socket = server.accept();
                clientCount++;
                System.out.println("Client #" + clientCount + " connected.");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (Exception ex) {
                System.out.println("Exception caught: " + ex);
            }
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                if (request != null) {
                    System.out.println("Received: " + request);
                    // Here you can apply SQL Injection attacks.
                    // SQL queries should be parameterized to protect against these attacks.
                    // However, in this case, we are not using any parameterized queries, 
                    // so the SQL Injection attack is not possible.

                    // Buffer Overflow attack is not possible here.
                    // This server does not have any code that can overflow a buffer.

                    writer.write("OK\n".getBytes());
                }
            } catch (IOException ex) {
                System.out.println("Exception caught: " + ex);
            }
        }
    }
}