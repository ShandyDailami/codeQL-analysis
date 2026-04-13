import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34718_SocketServer_A01 {

    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        startServer(port);
    }

    private static void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException ex) {
            System.out.println("Server failed to bind port " + port);
            System.exit(-1);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_34718_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client data here
            // For brevity, we'll just simply accept all incoming data
            try (clientSocket;
                 java.io.BufferedReader in = new java.io.BufferedReader(clientSocket.getInputStream())) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // For brevity, we'll simply echo back the message
                    clientSocket.getOutputStream().write((message + "\n").getBytes());
                    clientSocket.getOutputStream().flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}