import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41384_SocketServer_A08 {

    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(5);

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            executorService.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_41384_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        out.println("Goodbye!");
                        break;
                    }

                    out.println("Server: " + message);
                    out.flush();

                    System.out.println("Client: " + in.readLine());

                    if (message.equalsIgnoreCase("error")) {
                        throw new RuntimeException("A serious error occurred!");
                    }
                }

                clientSocket.close();
                System.out.println("Client disconnected");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}