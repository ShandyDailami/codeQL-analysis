import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35204_SocketServer_A01 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                executor.execute(new EchoHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class EchoHandler implements Runnable {

        private final Socket socket;

        public java_35204_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getInputStream();
                 socket.getOutputStream()) {

                // read and write
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                    socket.getOutputStream().flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}