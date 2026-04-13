import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_13803_SocketServer_A07 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                executor.execute(new ClientHandler(socket));
            }
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_13803_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                String message = in.readUTF();
                System.out.println("Received: " + message);
                if (message.equals("A07_AuthFailure")) {
                    out.writeUTF("AuthFailure");
                    out.flush();
                } else {
                    out.writeUTF("Unauthorized access");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}