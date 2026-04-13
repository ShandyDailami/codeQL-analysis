import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_27068_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newFixedThreadPool(5);

        SSLServerSocket sslServerSocket = (SSLServerSocket) SSLServerSocketFactory.createServerSocket(8080, null, null,
                KeyStore.getDefaultType(), "truststore.jks".toFile(), "password".toCharArray());

        while (true) {
            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket.getTransportSocket();
            sslSocket.setNeedClientAuth(true);

            Handler handler = new Handler(sslSocket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String message;

                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                }

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("Hello, Client!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}