import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_13677_SocketServer_A07 {

    private final static int PORT = 8888;
    private final static int NTHREADS = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);

        ServerSocket serverSocket = null;

        // Create SSL Server Socket
        serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Server started with port " + PORT);

        while (true) {
            final SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);

            executor.execute(new Runnable() {
                public void run() {
                    handleRequest(socket);
                }
            });
        }
    }

    private static void handleRequest(SSLSocket socket) {
        // handle request...
    }
}