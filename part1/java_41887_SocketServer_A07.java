import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_41887_SocketServer_A07 {

    private static final int PORT = 7777;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected.");
            Runnable task = new Runnable() {
                public void run() {
                    try {
                        handleRequest(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(task);
        }
    }

    private static void handleRequest(SSLSocket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello Client, you connected to the server!");
    }
}