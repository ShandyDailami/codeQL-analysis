import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24588_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from: " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_24588_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    if (isAttacksafe(clientMessage)) {
                        System.out.println("Attacksafe message: " + clientMessage);
                    } else {
                        System.out.println("Dangerous message: " + clientMessage);
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isAttacksafe(String message) {
            // Implement the logic to check if the message is attacksafe
            // This logic should be based on your specific application requirements
            // For example, you can check if the message contains specific words or phrases

            // For simplicity, let's assume the message is attacksafe if it contains the word "bad"
            return message.toLowerCase().contains("bad");
        }
    }
}