import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18312_SocketServer_A08 {

    private static final int PORT = 8080;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            executorService = Executors.newFixedThreadPool(10);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());
                executorService.execute(new SocketHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (executorService != null) executorService.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;

        public java_18312_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request;
                while ((request = reader.readLine()) != null) {
                    if (request.contains("IntegrityFailure")) {
                        writer.writeBytes("You made a request to an integrity failure A08_IntegrityFailure\n");
                    } else {
                        writer.writeBytes("You made a request: " + request + "\n");
                    }
                    writer.flush();
                }

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}