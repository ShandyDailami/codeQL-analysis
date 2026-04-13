import java.io.*;
import java.net.*;
import java.util.*;

public class java_32258_SocketServer_A07 {

    private static ArrayList<PrintWriter> clientOutputStreams = new ArrayList<>();

    public static void main(String[] args) {
        int port = 4444;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                clientOutputStreams.add(out);

                HandlerThread thread = new HandlerThread(socket.getInetAddress().toString());
                thread.start();
                ThreadSafeInputHandler inputHandler = new ThreadSafeInputHandler(socket, this);
                thread.getOutputStream().write('0');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This class handles input from one client and sends it to all other clients
    private class ThreadSafeInputHandler extends Thread {
        private final Socket socket;
        private final SecureChatServer server;

        public java_32258_SocketServer_A07(Socket socket, SecureChatServer server) {
            this.socket = socket;
            this.server = server;
        }

        @Override
        public void run() {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message;

            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received : " + message);
                    server.broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        private void broadcast(String message) {
            String broadcastMessage = message + "\r\n";

            for (PrintWriter clientOutputStream : clientOutputStreams) {
                clientOutputStream.println(broadcastMessage);
            }
        }

        private void closeConnection() {
            try {
                socket.close();
                clientOutputStreams.remove(this);
                System.out.println("Connection closed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}