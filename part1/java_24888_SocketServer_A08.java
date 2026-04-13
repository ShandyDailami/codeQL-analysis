import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24888_SocketServer_A08 {

    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new thread for each client connection
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle client connection and data here
        // For example, if client sends a message, server can respond by sending the same message back to client

        try (SocketWriter writer = new SocketWriter(clientSocket);
             SocketReader reader = new SocketReader(clientSocket)) {

            String message = reader.readLine();
            if ("exit".equals(message)) {
                System.out.println("Client disconnected.");
            } else {
                writer.writeLine("You said: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketReader extends InputStreamReader {
        public java_24888_SocketServer_A08(Socket socket) {
            super(socket.getInputStream());
        }

        public String readLine() throws IOException {
            byte[] buffer = new byte[1024];
            int bytesRead = read(buffer);
            return new String(buffer, 0, bytesRead);
        }
    }

    static class SocketWriter extends OutputStreamWriter {
        public java_24888_SocketServer_A08(Socket socket) {
            super(socket.getOutputStream());
        }

        public void writeLine(String message) throws IOException {
            write(message + "\n");
        }
    }
}