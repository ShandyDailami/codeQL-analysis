import javax.net.ssl.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_04333_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = null;
        try {
            server = new ServerSocket(12345);
            server.setReuseAddress(true);
            System.out.println("Server started at port 12345");
            SSLServerSocket sslServer = (SSLServerSocket) server.accept();
            SSLSocket socket = (SSLSocket) sslServer.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            Handler handler = new Handler(input, output);
            executor.execute(handler);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        executor.shutdown();
    }

    private static class Handler implements Runnable {
        private InputStream input;
        private OutputStream output;

        public java_04333_SocketServer_A03(InputStream input, OutputStream output) {
            this.input = input;
            this.output = output;
        }

        @Override
        public void run() {
            try {
                int c;
                while ((c = input.read()) != -1) {
                    output.write(c);
                }
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}