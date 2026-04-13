import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08692_SocketServer_A07 {
    private ExecutorService executor;
    private static final String AUTH_SUCCESS = "AUTH_SUCCESS";
    private static final String AUTH_FAILURE = "AUTH_FAILURE";

    public java_08692_SocketServer_A07(int port) {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_08692_SocketServer_A07(Socket socket) {
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
            String message;
            try {
                if ((message = reader.readLine()) != null) {
                    if (message.equals("AUTH_REQUEST")) {
                        writer.println(AUTH_SUCCESS);
                    } else {
                        writer.println(AUTH_FAILURE);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AuthServer(5000);
    }
}