import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_12652_SocketServer_A07 {

    private ExecutorService executor;

    public java_12652_SocketServer_A07(int port) {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted a new connection from " + clientSocket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_12652_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Client says: " + line);
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println("Server says: " + line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080);
    }
}