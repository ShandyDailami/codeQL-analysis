import java.io.*;
import java.net.*;
import java.util.*;

public class java_03245_SocketServer_A08 {

    private static final String DISPLAY_MESSAGE = "Message received: %s";
    private static final String DISCONNECT_MESSAGE = "Client disconnected";

    private static Set<Socket> clientSockets = Collections.newSet();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("New client connected");

            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }

    private static class SocketHandler implements Runnable {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_03245_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    for (Socket socket : clientSockets) {
                        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                        writer.println(String.format(DISPLAY_MESSAGE, message));
                    }
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                clientSocket.close();
                clientSockets.remove(clientSocket);
                System.out.println("Client disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}