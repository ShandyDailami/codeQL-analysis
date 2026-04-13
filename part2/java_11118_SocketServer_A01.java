import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11118_SocketServer_A01 {

    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static int port = 12345;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for client on port " + port);
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            System.out.println("Server shut down");
        }
    }

    private static void handleClient(Socket clientSocket) {
        executor.submit(new SocketHandler(clientSocket));
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        public java_11118_SocketServer_A01(Socket socket) { this.socket = socket; }
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String message = dataInputStream.readUTF();
                System.out.println("Received: " + message);
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
                System.out.println("Closed connection from " + socket.getRemoteSocketAddress());
            }
        }
    }
}