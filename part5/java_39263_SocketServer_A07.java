import java.io.*;
import java.net.*;
import java.util.*;

public class java_39263_SocketServer_A07 {

    private static final int PORT = 6789;
    private static List<Socket> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());
            clients.add(client);

            Thread clientHandler = new Thread(new SocketHandler(client));
            clientHandler.start();
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_39263_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                close(clientSocket);
                System.out.println("Error in SocketHandler initialization");
            }
        }

        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    processRequest(request);
                }
            } catch (IOException e) {
                close(clientSocket);
                System.out.println("Error in SocketHandler reading/writing");
            }
        }

        private void processRequest(String request) {
            // TODO: Add your code here for security-sensitive operations related to A07_AuthFailure
            // This is a placeholder.

            out.println("OK");
        }

        private void close(Socket socket) {
            try {
                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                System.out.println("Error in SocketHandler closing");
            }
        }
    }
}