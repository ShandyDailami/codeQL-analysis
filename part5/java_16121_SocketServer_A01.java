import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16121_SocketServer_A01 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            Future<?> future = executor.submit(() -> {
                try (InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {

                    int request;
                    while ((request = in.read()) != -1) {
                        out.write(request);
                        out.flush();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}