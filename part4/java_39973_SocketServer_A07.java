import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39973_SocketServer_A07 {

    private ExecutorService executor;

    public java_39973_SocketServer_A07() {
        executor = Executors.newFixedThreadPool(5);
    }

    public void start(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_39973_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    String responseMessage;

                    if (clientMessage.equals("auth fail")) {
                        responseMessage = "auth fail";
                    } else {
                        responseMessage = "auth success";
                    }

                    writer.println(responseMessage);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(8080);
    }
}