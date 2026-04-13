import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import javax.net.ssl.*;

public class java_39453_SocketServer_A08 {

    private SSLServerSocket serverSocket;
    private Socket socket;

    public java_39453_SocketServer_A08(int port) {
        SSLServerSocket socket = null;
        try {
            SSLServerSocket socket = (SSLServerSocket) new SSLServerSocket(port);
            socket.setNeedClient(true);
            socket.setEnabledCipherSuites(
                    SSLServerSocket.getDefaultEnabledCipherSuiteList());
            socket.setEnabledProtocols(
                    SSLServerSocket.getDefaultEnabledProtocolList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.serverSocket = socket;
    }

    public void startServer() {
        System.out.println("Starting Socket Server");
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    startServer();
                    while (true) {
                        socket = serverSocket.accept();
                        System.out.println("Accepted new connection from " + socket);

                        // Here you can handle the client's request
                        // For now, let's just close the connection
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        new SocketServer(8080).startServer();
    }
}