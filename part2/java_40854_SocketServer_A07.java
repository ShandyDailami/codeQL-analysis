import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40854_SocketServer_A07 {

    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(12345); // listen on port 12345
        while (true) {
            Socket socket = serverSocket.accept(); // accept a client connection
            executorService.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_40854_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                String request = reader.readLine(); // read the request from the client

                // TODO: Implement authentication logic
                // for simplicity, we'll just check if the request is empty
                if (request.isEmpty()) {
                    writer.writeBytes("A07_AuthFailure\n");
                    return;
                }

                // TODO: Implement authentication process
                // for simplicity, we'll just write a success message back to the client
                writer.writeBytes("Authentication successful\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}