import java.io.*;
import java.net.*;
import java.util.*;

public class java_00163_SocketServer_A03 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Send client's IP and port to client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Client's IP: " + socket.getInetAddress().getHostAddress());
                out.println("Client's Port: " + socket.getPort());

                clients.add(socket);

                Thread thread = new Thread(new ServerThread(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* Nothing to do */ }
            }
        }
    }

    private static class ServerThread implements Runnable {
        Socket socket;

        public java_00163_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }
                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}