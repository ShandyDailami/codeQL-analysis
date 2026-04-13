import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41173_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_41173_SocketServer_A03(Socket socket) {
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

                    // For the sake of this example, let's send back the message in upper case.
                    String upperCaseMessage = message.toUpperCase();
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println(upperCaseMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}