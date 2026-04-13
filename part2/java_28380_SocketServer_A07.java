import java.io.*;
import java.net.*;
import java.util.*;

public class java_28380_SocketServer_A07 {

    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);

        while (true) {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort());
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clientHandlers.add(clientHandler);

            clientHandler.startHandling();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_28380_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    handleMessage(message);
                }
            } catch (Exception e) {
                close();
            }
        }

        private void handleMessage(String message) {
            // handle the message...
        }

        private void close() {
            // close the socket, log the event, and remove the handler from the list.
        }
    }
}