import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_20659_SocketServer_A08 {
    private final int port;
    private final ExecutorService executor;

    public java_20659_SocketServer_A08(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() throws Exception {
        SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocket.create(port, null);
        serverSocket.setNeedClient(true);
        serverSocket.setUseClientMode(true);
        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream input = clientSocket.getInputStream();
                        OutputStream output = clientSocket.getOutputStream();
                        byte[] bytes = new byte[1024];
                        int length;
                        while ((length = input.read(bytes)) != -1) {
                            byte[] integrityCheck = new byte[length];
                            System.arraycopy(bytes, 0, integrityCheck, 0, length);
                            output.write(integrityCheck);
                            output.flush();
                        }
                        clientSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) throws Exception {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
    }
}