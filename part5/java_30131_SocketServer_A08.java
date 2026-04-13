import java.io.*;
import java.net.*;
import java.util.*;

public class java_30131_SocketServer_A08 {
    private static final String INET_ADDR = "localhost";
    private static final int PORT = 4446;
    private static Set<Socket> clients = new HashSet<>();
    private static SocketServerThread serverThread = null;

    public static void main(String[] args) {
        serverThread = new SocketServerThread();
        serverThread.start();
    }

    private static class SocketServerThread extends Thread {
        private ServerSocket serverSocket;

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(PORT);
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected!");
                    clients.add(clientSocket);
                    SocketServerThread clientThread = new SocketServerThread(clientSocket);
                    clientThread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public java_30131_SocketServer_A08(Socket socket) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println("Connected to the server!");
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    out.println("Echo: " + input);
                }
                clients.remove(socket);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}