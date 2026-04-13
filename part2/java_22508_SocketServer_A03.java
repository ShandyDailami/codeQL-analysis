import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class java_22508_SocketServer_A03 {
    private final SSLServerSocket serverSocket;
    private static final String CLIENT_KEY = "client.key";
    private static final String CLIENT_CERT = "client.crt";

    public java_22508_SocketServer_A03(int port) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port, null, InetAddress.getByName("localhost"));
        serverSocket.setNeedClientAuth(true);
    }

    public void start() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                        clientSocket.startHandshake();
                        System.out.println("Client accepted!");
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received: " + message);
                            out.println("Echo: " + message);
                        }

                        clientSocket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        try {
            SecureSocketServer server = new SecureSocketServer(1234);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}