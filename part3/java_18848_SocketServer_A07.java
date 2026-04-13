import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18848_SocketServer_A07 {

    private static final String SHARED_SECRET = "secret";
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_18848_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readLine();
                if (authenticateClient(clientMessage)) {
                    out.writeBytes("Authentication successful\n");
                } else {
                    out.writeBytes("Authentication failed\n");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticateClient(String clientMessage) {
            return clientMessage.equals(SHARED_SECRET);
        }
    }
}