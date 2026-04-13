import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06086_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");
            HandleClient clientHandler = new HandleClient(socket);
            executor.execute(clientHandler);
        }
    }

    static class HandleClient implements Runnable {
        private Socket socket;

        public java_06086_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Server says: " + inputLine);
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}