import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class java_34439_SocketServer_A07 {

    private static final String CLIENT_MESSAGE = "Client says: ";
    private static final String SERVER_MESSAGE = "Server says: ";

    public static void main(String[] args) {

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
                System.out.println("Client connected");

                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                String userInput;
                while ((userInput = in.readLine()) != null) {
                    System.out.println(CLIENT_MESSAGE + userInput);
                    out.println(SERVER_MESSAGE + userInput);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}