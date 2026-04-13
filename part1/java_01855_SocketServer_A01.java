import java.io.*;
import java.net.*;
import java.util.*;

public class java_01855_SocketServer_A01 {

    private static List<Socket> clientList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                clientList.add(socket);

                Thread clientThread = new Thread(new SocketHandler(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_01855_SocketServer_A01(Socket socket) {
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
                    System.out.println("Client says: " + message);
                    // Here you can implement a security-sensitive operation related to A01_BrokenAccessControl.
                    // For instance, you can check if the message contains a specific keyword and block or log the client if it does.
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();

                clientList.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}