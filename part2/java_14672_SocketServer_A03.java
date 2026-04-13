import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14672_SocketServer_A03 {
    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_14672_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesCount = in.read(buffer);

                String command = new String(buffer, 0, bytesCount);
                System.out.println("Received command: " + command);

                if (command.equals("exit")) {
                    socket.close();
                    System.out.println("Client disconnected");
                } else {
                    String response = "Command accepted";
                    out.write(response.getBytes());
                    System.out.println("Sent response: " + response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}