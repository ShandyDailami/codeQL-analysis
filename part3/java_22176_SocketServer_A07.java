import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_22176_SocketServer_A07 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    logger.info("Received message: " + message);
                    // Here is the part where you should implement authentication.
                    // For simplicity, let's just check if the message is "hello".
                    if ("hello".equals(message)) {
                        out.println("Hello, client, authenticated!");
                    } else {
                        out.println("Unauthenticated client!");
                    }
                    out.flush();
                }
                clientSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}