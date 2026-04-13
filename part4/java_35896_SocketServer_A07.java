import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_35896_SocketServer_A07 {

    private static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                HandleClient clientHandler = new HandleClient(socket);
                executor.execute(clientHandler);
            } catch (IOException e) {
                System.out.println("Error handling client.");
                e.printStackTrace();
                break;
            }
        }

        executor.shutdown();
    }
}

class HandleClient implements Runnable {

    private Socket socket;

    public java_35896_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);
                if ("exit".equals(request)) {
                    writer.println("Goodbye!");
                    break;
                }
                if ("auth".equals(request)) {
                    writer.println("Username: password");
                    break;
                }

                if (!"auth".equals(request)) {
                    writer.println("Server: Hello, client!");
                }
            }
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}