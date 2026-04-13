import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09645_SocketServer_A03 {
    private static ExecutorService executor;
    private static boolean running = true;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = null;
        try {
            server = new ServerSocket(2222); // Port
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server is starting...");
        while (running) {
            try {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");
                executor.execute(new ClientHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
                break;
            }
        }

        executor.shutdown();
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_09645_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read request from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request;
            while ((request = in.readLine()) != null) {
                // Handle request
                System.out.println("Received: " + request);

                // Send response back to client
                out.writeBytes("Hello client, you sent: " + request + "\n");
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}