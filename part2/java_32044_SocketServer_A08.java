import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_32044_SocketServer_A08 {

    private static final ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        SSLServerSocket sslServer = null;
        try {
            server = new ServerSocket(8080);
            SSLServerSocketFactory sslServerFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServer = (SSLServerSocket) sslServerFactory.createServerSocket(8080);
            sslServer.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (true) {
            try {
                Socket socket = sslServer.accept();
                System.out.println("Client connected");
                pool.execute(new SocketHandler(socket));
            } catch (SocketTimeoutException e) {
                System.out.println("No client connection for 5 seconds");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_32044_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream writer = new DataOutputStream(outputStream);
                String line = reader.readLine();
                while (line != null) {
                    System.out.println("Received: " + line);
                    line = reader.readLine();
                }
                writer.write("HTTP/1.1 200 OK\r\n".getBytes());
                writer.write("Content-Type: text/html\r\n".getBytes());
                writer.write("\r\n".getBytes());
                writer.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}