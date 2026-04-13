import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25322_SocketServer_A03 {

    private static final String SERVER_STATUS = "Server started";
    private static final String SERVER_PORT = "12345";

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(Integer.parseInt(SERVER_PORT));

        System.out.println(SERVER_STATUS);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_25322_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                handleInput(socket.getInputStream());
                socket.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handleInput(InputStream input) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                if (clientMessage.contains("A03_Injection")) {
                    System.out.println("Violation detected: " + clientMessage);
                }
            }
        }
    }
}