import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29463_SocketServer_A07 {

    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_29463_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newFixedThreadPool(10);
    }

    public void startServer() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());
        while (true) {
            try {
                Future<Socket> future = executor.submit(() -> serverSocket.accept());
                Socket client = future.get();
                executor.submit(() -> new SocketHandler(client).startHandling());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Server stopped");
    }

    private class SocketHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_29463_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Hello, client!");
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

    public static void main(String[] args) {
        try {
            new SecureSocketServer(8080).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}