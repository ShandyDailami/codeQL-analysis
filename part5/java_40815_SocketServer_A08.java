import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40815_SocketServer_A08 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_40815_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equals("close")) {
                        writer.writeBytes("Connection closed by the client\n");
                        socket.close();
                        return;
                    }

                    // Here we use the message as is for simplicity. In a real scenario, 
                    // you should perform some security-sensitive operations related to A08_IntegrityFailure here.
                    writer.writeBytes("Server received: " + message + "\n");
                }

                writer.writeBytes("Connection closed by the client\n");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}