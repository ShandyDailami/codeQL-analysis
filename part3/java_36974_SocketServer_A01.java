import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36974_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_36974_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage = reader.readLine();
                System.out.println("Received: " + clientMessage);

                if (clientMessage.equals("Hello, client")) {
                    writer.writeBytes("Hello, server\n");
                } else {
                    writer.writeBytes("Access denied\n");
                }

                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}