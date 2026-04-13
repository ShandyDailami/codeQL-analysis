import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_15972_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (executor != null) {
                executor.shutdown();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_15972_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String msg = in.readUTF();
                System.out.println("Received: " + msg);

                // Replace A08_IntegrityFailure with a real security-sensitive operation
                if (msg.contains("A08_IntegrityFailure")) {
                    System.out.println("Integrity failure detected, replacing message with placeholder...");
                    msg = "Security violation detected, please contact the administrator!";
                }

                out.writeUTF(msg);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}