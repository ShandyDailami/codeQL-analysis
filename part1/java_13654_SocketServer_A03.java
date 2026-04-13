import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_13654_SocketServer_A03 {

    private static final int PORT = 8888;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, null, InetAddress.getByName(IP));
            System.out.println("Server is running...");

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                            String request;
                            while ((request = in.readLine()) != null) {
                                System.out.println("Received: " + request);
                                out.println("Server received your message");
                            }
                            clientSocket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}