import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_12876_SocketServer_A07 {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189...");

        while (true) {

            Socket client = server.accept();
            System.out.println("Accepted new connection from " + client.getRemoteSocketAddress());

            Handler handler = new Handler(client);
            exec.execute(handler);
        }
    }

    static class Handler implements Runnable {

        Socket sock;
        BufferedReader in;
        PrintWriter out;

        Handler(Socket sock) {
            this.sock = sock;
            try {
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                out = new PrintWriter(sock.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void close() {
            if (sock != null) {
                try { sock.close(); } catch (IOException e) {}
                sock = null;
                in = null;
                out = null;
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        close();
                        break;
                    } else {
                        System.out.println("Received: " + message);
                        out.println("Echo: " + message);
                        out.flush();
                    }
                }
            } catch (IOException e) {
                close();
            }
        }
    }
}