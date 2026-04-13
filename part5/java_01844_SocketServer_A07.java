import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_01844_SocketServer_A07 {

    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_01844_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server is listening on port " + serverSocket.getLocalPort());

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (IOException e) {
                serverSocket.close();
                System.out.println("Failed to accept connection");
                break;
            }
        }

        executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(1234);
        server.startServer();
    }

    private class Handler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_01844_SocketServer_A07(Socket socket) {
            this.socket = socket;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            String message;

            while (true) {
                try {
                    if ((message = reader.readLine()) != null) {
                        System.out.println("Received: " + message);

                        if ("exit".equals(message)) {
                            closeConnection();
                            break;
                        } else {
                            writer.println("Hello, client. You entered: " + message);
                        }
                    } else {
                        closeConnection();
                        break;
                    }
                } catch (IOException e) {
                    closeConnection();
                    break;
                }
            }
        }

        private void closeConnection() {
            executor.submit(new Runnable() {
                public void run() {
                    try {
                        reader.close();
                        writer.close();
                        socket.close();
                        System.out.println("Connection closed");
                    } catch (IOException e) {
                        System.out.println("Failed to close connection");
                    }
                }
            });
        }
    }
}