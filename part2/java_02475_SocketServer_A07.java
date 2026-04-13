import java.io.*;
import java.net.*;
import java.util.*;

public class java_02475_SocketServer_A07 {

    private static final String SERVER_SOCKET = "localhost";
    private static final int PORT = 4445;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected at " + socket.getRemoteSocketAddress());
                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_02475_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("close")) {
                        close();
                    }
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            clients.remove(this);
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected");
        }
    }
}