import java.io.*;
import java.net.*;

public class java_34923_SocketServer_A01 {
    private static int DEFAULT_PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            HandleClient clientHandler = new HandleClient(clientSocket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }

    private static class HandleClient implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_34923_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeCurrentIOStreams();
            }
        }

        public void run() {
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    if ("exit".equals(request)) {
                        closeCurrentIOStreams();
                        break;
                    } else if (request.startsWith("secure:")) {
                        String secureRequest = request.substring(8);
                        String response = handleSecureRequest(secureRequest);
                        out.println(response);
                    } else {
                        out.println("Invalid request: " + request);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void closeCurrentIOStreams() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String handleSecureRequest(String secureRequest) {
            // Implement security-sensitive operations related to A01_BrokenAccessControl
            // For instance, checking for permissions or access rights to the request

            // For the purpose of this example, we'll just return a simple response
            return "Secure response from client: " + secureRequest;
        }
    }
}