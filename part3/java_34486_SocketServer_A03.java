import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34486_SocketServer_A03 {

    private ExecutorService executor;
    private ServerSocket server;

    public java_34486_SocketServer_A03(int port) {
        try {
            server = new ServerSocket(port);
            executor = Executors.newCachedThreadPool();
            System.out.println("Server is listening on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while(true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopServer() {
        try {
            server.close();
            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LegacyServer server = new LegacyServer(8080);
        server.startServer();
    }

    class Handler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_34486_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}