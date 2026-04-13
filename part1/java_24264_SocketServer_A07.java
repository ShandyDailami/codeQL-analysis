import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24264_SocketServer_A07 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            Handler handler = new Handler(socket);
            executor.submit(handler);
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_24264_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        out.println("Connection closed by client");
                        socket.close();
                    } else {
                        out.println("Server: Hello client, you entered: " + message);
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}