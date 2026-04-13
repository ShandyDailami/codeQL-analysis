import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_01564_SocketServer_A07 {
    private static final int PORT = 8080;
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_PASSWORD = "clientPassword";
    private static final String SERVER_KEY_STORE = "server.jks";
    private static final String SERVER_KEY_PASSWORD = "serverPassword";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            System.out.println("Server started...");

            ExecutorService executorService = Executors.newFixedThreadPool(10);

            while (true) {
                final SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected...");

                executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            OutputStream outputStream = socket.getOutputStream();

                            // Read the request
                            byte[] buffer = new byte[1024];
                            int length = inputStream.read(buffer);
                            String request = new String(buffer, 0, length);
                            System.out.println("Received request: " + request);

                            // Send the response
                            String response = "Hello, client!";
                            outputStream.write(response.getBytes());
                            System.out.println("Sent response: " + response);

                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}