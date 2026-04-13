import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16876_SocketServer_A08 {

    private static ExecutorService executor;
    private static int port = 12345;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {

        Socket socket;

        public java_16876_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Add security-sensitive operation related to A08_IntegrityFailure here.

                    // For example, we'll send back the received message as is
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}