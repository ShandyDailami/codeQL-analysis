import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14957_SocketServer_A08 {
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            try {
                Socket clientSocket = server.accept();
                System.out.println("New client connected");
                Handler handler = new Handler(clientSocket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
                server.close();
            }
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;

        public java_14957_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);

                    // Sending back a response
                    outputStream.write((line + "\n").getBytes());
                    outputStream.flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}