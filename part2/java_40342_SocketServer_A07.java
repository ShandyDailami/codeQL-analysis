import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40342_SocketServer_A07 {
    private static final int PORT = 8080;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            try {
                System.out.println("Waiting for client on port " + PORT);
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected on port " + clientSocket.getPort());
                Handler handler = new Handler(clientSocket);
                executorService.execute(handler);
            } catch (IOException ex) {
                System.out.println("IOException in: " + ex.getMessage());
                break;
            }
        }
        serverSocket.close();
    }

    static class Handler implements Runnable {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                // read the username and password from the client
                String username = reader.readLine();
                String password = reader.readLine();

                // validate the username and password against a database or external file
                // for the simplicity of this example, let's just check if the username is "admin" and password is "secret"
                if ("admin".equals(username) && "secret".equals(password)) {
                    writer.writeBytes("Authenticated\n");
                } else {
                    writer.writeBytes("Failed to authenticate\n");
                }

                writer.close();
            } catch (IOException ex) {
                System.out.println("IOException in: " + ex.getMessage());
            }
        }
    }
}