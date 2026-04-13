import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22716_SocketServer_A07 {

    private final ExecutorService executor;
    private final int port;

    public java_22716_SocketServer_A07(int port) {
        this.port = port;
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running and waiting for client connections on port " + port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client connected");
            executor.execute(new Handler(clientSocket));
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private class Handler implements Runnable {

        private final Socket socket;

        public java_22716_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                DataOutputStream writer = new DataOutputStream(out);

                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equals("exit")) {
                        writer.writeBytes("Goodbye client\n");
                        break;
                    } else {
                        writer.writeBytes("Hello, " + message + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}