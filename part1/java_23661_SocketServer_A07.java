import java.io.*;
import java.net.*;
import java.util.*;

public class java_23661_SocketServer_A07 {
    private static final String[] AUTHORIZED_CLIENTS = {"192.168.1.100", "192.168.1.200"}; // Replace with actual authorized clients
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Bind to port 12345
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                if (authorizeClient(socket.getRemoteSocketAddress().toString())) {
                    clientSockets.add(socket);
                    new Handler(socket).start();
                } else {
                    System.out.println("Client " + socket.getRemoteSocketAddress() + " is not authorized");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authorizeClient(String ip) {
        return Arrays.asList(AUTHORIZED_CLIENTS).contains(ip);
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_23661_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}