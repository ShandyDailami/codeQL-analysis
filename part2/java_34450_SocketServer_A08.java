import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_34450_SocketServer_A08 {

    private static final String PASSWORD = "securepassword";
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException, InterruptedException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            serverSocket.setNeedClientAuthentication(true);
            executor = Executors.newCachedThreadPool();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new SocketHandler(clientSocket));
            }
        } finally {
            serverSocket.close();
            executor.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_34450_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SSLServerSocket serverSocket = (SSLServerSocket) socket.getSocket();
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                String clientInput;
                while ((clientInput = in.readLine()) != null) {
                    if (clientInput.equals(PASSWORD)) {
                        out.writeBytes("Authorized\n");
                    } else {
                        out.writeBytes("Access Denied\n");
                    }
                    out.flush();
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}