import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_12001_SocketServer_A01 {
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(5);

        ServerSocket serverSocket = new ServerSocket(9876);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_12001_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage = reader.readLine();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello, client!";
                writer.writeBytes(serverMessage + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}