import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31983_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(9876);
        System.out.println("Server started on port 9876");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            executor.execute(clientHandler);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_31983_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // For demonstration purposes, we're not executing the received command,
                // but here's a simple example of an SQL Injection attack.
                // You should not do this, as it's a violation of the principle of least privilege.
                // The server should always check the SQL query and sanitize the input.
                if (clientMessage.contains("DROP TABLE")) {
                    out.println("Attempting to drop table");
                    out.flush();
                } else {
                    out.println("Command accepted: " + clientMessage);
                    out.flush();
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}