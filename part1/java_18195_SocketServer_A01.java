import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18195_SocketServer_A01 {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static int clientCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientCount++;
            System.out.println("Client #" + clientCount + " connected from " + clientSocket.getRemoteSocketAddress());
            Handler handler = new Handler(clientSocket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        public java_18195_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String response = "Hello, client " + clientCount + "\n";
                    OutputStream output = socket.getOutputStream();
                    output.write(response.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}