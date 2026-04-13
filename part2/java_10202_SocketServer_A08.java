import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_10202_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            ClientHandler clientHandler = new ClientHandler(socket);
            executor.execute(clientHandler);
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_10202_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    // Add security-sensitive operations related to A08_IntegrityFailure here
                    // For example, sending back a response to the client
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(("Server: " + message + "\n").getBytes());
                    outputStream.flush();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}