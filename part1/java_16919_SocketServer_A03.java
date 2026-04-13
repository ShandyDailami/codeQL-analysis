import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_16919_SocketServer_A03 {

    private static final int PORT = 8443;
    private static final String PASSWORD = "securepassword";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setPasswordFilter(new PasswordFilter(PASSWORD));
            ExecutorService executorService = Executors.newCachedThreadPool();
            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                executorService.execute(new SocketHandler(clientSocket));
            }
        } finally {
            serverSocket.close();
            executorService.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private final SSLSocket socket;

        public java_16919_SocketServer_A03(SSLSocket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(outputStream, true);
                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    writer.println("Hello, " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PasswordFilter implements PasswordAuthentication {
        private final String password;

        public java_16919_SocketServer_A03(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public String getAlgorithmName() {
            return "SSL";
        }

        public boolean authenticate(String password) {
            return this.password.equals(password);
        }
    }
}