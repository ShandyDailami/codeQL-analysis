import java.io.*;
import java.net.*;
import java.util.*;

public class java_30260_SocketServer_A08 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 12345;
    private static final String EXIT_STRING = "exit";

    private static Set<Socket> clientSockets = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected");
                clientSockets.add(clientSocket);

                Thread thread = new Thread(new ClientHandlerThread(clientSocket));
                thread.start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ClientHandlerThread implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_30260_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                close(clientSocket);
                System.out.println("Error occurred while setting up I/O for " + clientSocket.getRemoteSocketAddress());
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals(EXIT_STRING)) {
                        System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " disconnected");
                        close(clientSocket);
                        break;
                    } else {
                        System.out.println("Received: " + message);
                        // Process the message for security sensitive operations
                        // ...

                        // Send a response back to the client
                        out.println("Received: " + message);
                        out.flush();
                    }
                }
            } catch (IOException e) {
                close(clientSocket);
                System.out.println("Error occurred while reading from or writing to " + clientSocket.getRemoteSocketAddress());
            }
        }

        private static void close(Socket socket) {
            try {
                socket.close();
                clientSockets.remove(socket);
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }
}