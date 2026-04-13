import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24176_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server started on port 9000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            ServerHandler handler = new ServerHandler(socket);
            executor.execute(handler);
        }
    }
}

class ServerHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_24176_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String request;
        try {
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);
                // handle request here...
                // send response back to client
                writer.println("Server received your message");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}