import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04814_SocketServer_A07 {

    private static final int PORT = 9876;
    private static final String SERVER_STATE = "SERVER_STATE";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ExecutorService executorService = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            executorService = Executors.newFixedThreadPool(10);
            while (true) {
                Future<Socket> future = serverSocket.accept();
                Socket socket = future.get();
                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_04814_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    if (clientMessage.equals(SERVER_STATE)) {
                        writer.writeBytes("A07_AuthFailure\n");
                        writer.flush();
                        System.out.println("AuthFailure detected. Server state is set to 'A07_AuthFailure'.");
                        break;
                    }
                    writer.writeBytes("Server received message: " + clientMessage + "\n");
                    writer.flush();
                }
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}