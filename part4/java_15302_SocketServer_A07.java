import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_15302_SocketServer_A07 {

    private static final String PORT_NUMBER = "1234";
    private static final String PASSWORD = "password";

    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(Integer.parseInt(PORT_NUMBER)));

        while (true) {
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            executorService.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_15302_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String passwordFromClient;
                if ((passwordFromClient = reader.readLine()) != null) {
                    if (passwordFromClient.equals(PASSWORD)) {
                        writer.println("Authentication successful");
                    } else {
                        writer.println("Authentication failed");
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}