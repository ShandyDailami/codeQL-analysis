import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18642_SocketServer_A08 {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
            pool.execute(new ClientHandler(client));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_18642_SocketServer_A08(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                DataOutputStream writer = new DataOutputStream(out);

                String request;
                while ((request = reader.readLine()) != null) {
                    if (request.equals("exit")) {
                        writer.writeBytes("Connection closed\n");
                        writer.flush();
                        client.close();
                        return;
                    }

                    // Realistic security operation here
                    // This is a placeholder for a real-world application.
                    // The server simply sends back the request.
                    writer.writeBytes(request + "\n");
                    writer.flush();
                }

                writer.writeBytes("Connection closed\n");
                writer.flush();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}