import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02096_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New client connected");
                executor.execute(new SocketHandler(socket));
            } catch (Exception e) {
                System.out.println("Exception occured when trying to accept the connection");
                e.printStackTrace();
            }
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;

        public java_02096_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                if ("exit".equals(request)) {
                    writer.writeBytes("Connection closed by client\n");
                    socket.close();
                } else {
                    writer.writeBytes("Hello client, you sent: " + request + "\n");
                }

                writer.flush();
            } catch (Exception e) {
                System.out.println("Exception occurred while reading or writing from/to the socket");
                e.printStackTrace();
            }
        }
    }
}