import java.io.*;
import java.net.*;
import java.util.*;

public class java_29217_SocketServer_A07 {
    private List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is listening on port 8189");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler handler = new ClientHandler(clientSocket);
                clients.add(handler);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_29217_SocketServer_A07(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    if ("auth".equals(message)) {
                        out.println("OK");
                    } else {
                        out.println("FAIL");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(this);
                socket.close();
                in = null;
                out = null;
            }
        }
    }
}