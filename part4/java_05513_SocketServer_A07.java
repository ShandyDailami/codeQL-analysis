import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05513_SocketServer_A07 {
    private static final int PORT = 6789;
    private static final String AUTH_FAILURE_MESSAGE = "Auth Failure: Invalid username or password.";
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(socket));
            } catch (IOException e) {
                System.out.println("Error accepting client connection");
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_05513_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);

                    if (clientMessage.equals("username password")) { // Simulate authentication
                        writer.writeBytes(AUTH_FAILURE_MESSAGE + "\n");
                    } else {
                        writer.writeBytes("Hello Client, Welcome! \n");
                    }
                    writer.flush();
                }

                socket.close();
            } catch (IOException e) {
                System.out.println("Error processing client connection");
                e.printStackTrace();
            }
        }
    }
}