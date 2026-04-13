import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class java_17082_SocketServer_A03 {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        ServerSocket sock = new ServerSocket(4444, 10000, null);
        sock.setReuseAddress(true);
        executor = Executors.newCachedThreadPool();

        SSLServerSocket serverSocket = (SSLServerSocket) sock;
        serverSocket.setNeedClientAuth(true);
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(KeyStore.getDefaultType());
        tmf.init(keyStore);
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, tmf.getTrustManagers(), null);
        serverSocket.setSSLContext(context);

        while (true) {
            Socket socket = serverSocket.accept();
            ServerWorker worker = new ServerWorker(socket);
            executor.submit(worker);
        }
    }

    static class ServerWorker implements Runnable {
        private Socket socket;

        public java_17082_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message = reader.readLine();
                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(message);

                if (!matcher.matches()) {
                    System.out.println("Invalid input: " + message);
                    return;
                }

                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println("Hello, " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}