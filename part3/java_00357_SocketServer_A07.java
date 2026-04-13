import java.io.*;
import java.net.*;
import java.util.*;

public class java_00357_SocketServer_A07 {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;
    private static Set<Socket> clients = Collections.synchronizedSet(new HashSet<Socket>());

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");
            clients.add(socket);
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        Thread thread = new Thread(new ClientHandler(socket));
        thread.start();
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        public java_00357_SocketServer_A07(Socket socket) { this.socket = socket; }
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                String message = dis.readUTF();
                System.out.println("Received message: " + message);
                String response = "Server response: " + message;
                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);
                dos.writeUTF(response);
                dos.flush();
                socket.close();
                clients.remove(socket);
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}