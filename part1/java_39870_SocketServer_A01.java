import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39870_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(5000);
    }

    public static void startServer(int port) {
        executor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                executor.execute(clientHandler);
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket clientSocket;
        public java_39870_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Server received your message");
                }
                clientSocket.close();
            } catch (IOException ex) {
                System.out.println("Error in client handling: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}