import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33472_SocketServer_A07 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_33472_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage = reader.readLine();
                System.out.println("Client: " + clientMessage);

                if ("auth".equals(clientMessage)) {
                    writer.writeBytes("ok\n");
                } else {
                    writer.writeBytes("fail\n");
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}