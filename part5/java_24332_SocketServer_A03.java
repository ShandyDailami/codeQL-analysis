import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_24332_SocketServer_A03 {

    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final byte[] KEY = "ThisIsAKey123".getBytes();

    private final ExecutorService executor;
    private SecretKeySpec secretKey;

    public java_24332_SocketServer_A03() {
        executor = Executors.newFixedThreadPool(5);
        secretKey = new SecretKeySpec(KEY, "AES");
    }

    public void start(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
            executor.execute(new SocketHandler(socket));
        }
    }

    class SocketHandler implements Runnable {
        private Socket socket;

        public java_24332_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.setSoTimeout(10000);
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedData = cipher.doFinal(socket.getInputStream().readAllBytes());
                socket.getOutputStream().write(encryptedData);
                socket.getOutputStream().flush();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}