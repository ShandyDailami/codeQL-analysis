import java.io.*;
import java.net.*;
import java.util.*;

public class java_19494_SocketServer_A07 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 8888;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            try {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);

                Handler handler = new Handler(clientSocket);
                new Thread(handler).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_19494_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeAll(socket, in, out);
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    sendToAll("Received: " + message);
                }
            } catch (IOException e) {
                closeAll(socket, in, out);
            }
        }

        private void sendToAll(String message) {
            for (PrintWriter client : clients) {
                client.println(message);
            }
        }

        private void closeAll(Socket socket, BufferedReader in, PrintWriter out) {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}