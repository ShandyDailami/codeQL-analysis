import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08607_SocketServer_A03 {

    private static final int DEFAULT_PORT = 3333;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        int port = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = new ServerSocket(port);
        while (true) {
            try {
                Socket client = server.accept();
                executor.execute(new ClientHandler(client));
            } catch (SocketTimeoutException t) {
                System.out.println("Timeout occurred!");
                t.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        executor.shutdown();
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_08607_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message, response;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    response = processInput(message);
                    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                    output.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection(clientSocket);
            }
        }

        private String processInput(String input) {
            // This is where the injection point will be.
            // The server will attempt to execute the following command: 'drop table users'
            // This is a very simple example and should not be used as-is in a real-world application.
            return "SQL Injection Success";
        }

        private static void closeConnection(Socket connection) {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}