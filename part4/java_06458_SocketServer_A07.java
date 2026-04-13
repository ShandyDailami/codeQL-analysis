import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06458_SocketServer_A07 {

    private static final String SERVER_SOCKET = "Server Socket";
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
            Handler handler = new Handler(clientSocket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        public java_06458_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                String clientMsg = dis.readUTF();
                System.out.println("Client says: " + clientMsg);

                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);
                String serverMsg = "Hello, client";
                dos.writeUTF(serverMsg);
                dos.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}