import java.net.*;
import java.io.*;

public class java_08749_SocketServer_A01 {
    private static int DEFAULT_PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(DEFAULT_PORT);
    }

    public static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final BufferedReader in;
    private final PrintWriter out;

    public java_08749_SocketServer_A01(Socket socket) throws IOException {
        this.clientSocket = socket;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}