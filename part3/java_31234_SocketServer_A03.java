import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_31234_SocketServer_A03 {

    private static final int PORT = 9876;
    private static final int CORE_POOL_SIZE = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException ex) {
            System.out.println("Server failed to start. Exiting.");
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_31234_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                String received = in.readUTF();
                System.out.println("Received message: " + received);

                String response = "Hello, " + received + ". You connected successfully!";
                out.writeUTF(response);
                System.out.println("Sent message: " + response);
            } catch (IOException ex) {
                System.out.println("Client failed to communicate. Exiting.");
                ex.printStackTrace();
            }
        }
    }
}