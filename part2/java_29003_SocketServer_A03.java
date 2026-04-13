import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLServer;
import javax.net.ssl.SSLSocket;

public class java_29003_SocketServer_A03 {

    private static ExecutorService executorService;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        executorService = Executors.newFixedThreadPool(10);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8888);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Server is running on port 8888");

        while (true) {
            socket = (SSLSocket) serverSocket.accept();
            System.out.println("Connection accepted from: " + socket.getRemoteSocketAddress());
            Handler handler = new Handler(socket);
            executorService.execute(handler);
        }
    }

    static class Handler implements Runnable {
        private final SSLSocket socket;

        Handler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}