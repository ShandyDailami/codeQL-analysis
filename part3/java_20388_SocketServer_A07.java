import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_20388_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        executor = Executors.newFixedThreadPool(10);

        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
        } catch (SSLException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                SSLSocket socket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                executor.execute(new SocketTask(socket));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    static class SocketTask implements Runnable {

        private final Socket socket;

        public java_20388_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}