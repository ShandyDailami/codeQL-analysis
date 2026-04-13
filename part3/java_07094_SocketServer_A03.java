import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.Scanner;

public class java_07094_SocketServer_A03 {

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080,
                    1024,
                    true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                Scanner scanner = new Scanner(inputStream);
                String clientMessage;

                while (true) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    clientMessage = scanner.nextLine();
                    System.out.println("Received: " + clientMessage);

                    // For example, we'll just echo back the message
                    outputStream.write((clientMessage + "\n").getBytes());
                    outputStream.flush();
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}