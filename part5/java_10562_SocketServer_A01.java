import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10562_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            SSLCertificate certificate = (SSLCertificate) sslSocket.getSession();

            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(sslSocket.getInputStream()));

            out.println("Hello Client, enter your name:");

            String userInput = in.readLine();
            out.println("Hello " + userInput + ", nice to meet you!");

            sslSocket.close();
        } catch (SSLException | IOException e) {
            e.printStackTrace();
        }
    }
}