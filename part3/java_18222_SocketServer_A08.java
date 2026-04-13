import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18222_SocketServer_A08 {
    private static ExecutorService executor;
    private static Socket socket;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (true) {
            try {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                final PrintWriter writer = new PrintWriter(outputStream, true);

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String message;
                            while ((message = reader.readLine()) != null) {
                                if (message.equals("close")) {
                                    writer.println("Connection closed");
                                    socket.close();
                                    System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
                                    break;
                                } else {
                                    writer.println("Server response: " + message);
                                }
                            }
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}