import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_40648_SocketServer_A08 {

    private static final int port = 8888;
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();

        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server started. Listening on port " + port + " ...");

        SSLHandler handler = new SSLHandler(serverSocket);
        while (true) {
            final SSLSocket clientSocket = (SSLSocket) handler.getSocket();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            executor.execute(new Runnable() {
                public void run() {
                    try {
                        out.println("Hello from the server!");
                        out.flush();

                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received message: " + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    static class SSLHandler extends Handler {
        private final SSLServerSocket serverSocket;

        public java_40648_SocketServer_A08(SSLServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public Socket getSocket() throws IOException {
            return serverSocket.accept();
        }
    }
}