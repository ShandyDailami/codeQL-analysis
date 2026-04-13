import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31600_SocketServer_A03 {
    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_31600_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server is listening on port " + serverSocket.getLocalPort());
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected to the server");
                Handler handler = new Handler(clientSocket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeServer() {
        executor.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        server.startServer();
    }
}

class Handler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public java_31600_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String clientMessage;
        while ((clientMessage = readFromClient()) != null) {
            processMessage(clientMessage);
        }
    }

    private String readFromClient() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void processMessage(String message) {
        // Security-sensitive operation: Check if the message contains a specific username and password
        // Here, for simplicity, we check if it contains a specific username and password
        if (message.contains("username") && message.contains("password")) {
            out.println("Access granted");
        } else {
            out.println("Access denied");
        }
    }
}