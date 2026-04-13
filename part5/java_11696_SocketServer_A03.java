import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11696_SocketServer_A03 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_SOCKET_PORT = 4444;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(SERVER_SOCKET_ADDRESS, SERVER_SOCKET_PORT));

        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        executor.execute(new ClientHandler(clientSocket));
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_11696_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                // handle exception
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                if (isEchoRequest(message)) {
                    sendEchoResponse(message);
                } else {
                    // handle other types of requests
                }
            }
            closeConnection();
        }

        private String readMessage() {
            try {
                return in.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        private void sendEchoResponse(String message) {
            out.println(message);
        }

        private void closeConnection() {
            try {
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                // handle exception
            }
        }

        private boolean isEchoRequest(String message) {
            // implement the logic to check if the message is an echo request
            // for example, if the message starts with "ECHO"
            return message.startsWith("ECHO");
        }
    }
}