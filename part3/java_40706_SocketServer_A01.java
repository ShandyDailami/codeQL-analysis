import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.InetAddress;

public class java_40706_SocketServer_A01 {
    public static void main(String[] args) {
        InetAddress address = InetAddress.getByName("localhost");
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 100, address);
            sslServerSocket.setNeedClientAuth(true);
            System.out.println("Waiting for client authentication...");

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Accepted new client connection from " + clientSocket.getRemoteSocketAddress());

                new HandleSocketTask(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleSocketTask extends Thread {
    private final SSLSocket socket;

    public java_40706_SocketServer_A01(SSLSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Read and handle the client's message
        // For now, just print out the message
        try {
            byte[] bytes = new byte[1024];
            int length = socket.getInputStream().read(bytes);
            String message = new String(bytes, 0, length);
            System.out.println("Received: " + message);

            // Write a response back to the client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}