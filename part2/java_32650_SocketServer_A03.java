import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32650_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        executor = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());
            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_32650_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Echo: " + inputLine);
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}