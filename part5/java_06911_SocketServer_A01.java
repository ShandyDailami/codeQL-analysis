import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_06911_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();

        System.out.println("Server is running on port: " + port);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Block non-SSL connections
                if (!(socket.getInputStream().getClass().getName().contains("javax.net.ssl."))) {
                    socket.close();
                    System.out.println("Connection from " + socket.getRemoteSocketAddress() + " is not secure and has been blocked");
                    continue;
                }

                // Handle the client connection
                executor.execute(new SocketHandler(socket));

            } catch (IOException e) {
                e.printStackTrace();
                serverSocket.close();
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_06911_SocketServer_A01(Socket socket) {
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
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // respond to client
                writer.println("Message received");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketDisconnect();
        }
    }

    private void socketDisconnect() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}