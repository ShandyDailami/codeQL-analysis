import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14848_SocketServer_A03 {

    private static final String SERVER_STATUS = "Server is running";
    private static final String SERVER_STOP = "Server has been stopped";
    private static ServerSocket serverSocket;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);
        try {
            serverSocket = new ServerSocket(9876);
            System.out.println("Server started at port: 9876");
            while (true) {
                System.out.println("Waiting for client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted");
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            System.out.println("Error accepting client");
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_14848_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    handleIncomingMessage(message);
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void handleIncomingMessage(String message) {
            // This is a placeholder for your actual logic of sending a response to the client
            // For example, it may send a response to the client based on the input message
            out.println(message);
            out.flush();
        }

        private void closeConnection() {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        in.close();
                        out.close();
                        clientSocket.close();
                        System.out.println("Client disconnected");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}