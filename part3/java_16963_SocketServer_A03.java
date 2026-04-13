import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class java_16963_SocketServer_A03 {

    public static void main(String[] args) {
        String password = "securepassword"; // password for server
        int port = 12345; // port number

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();

            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) socket;

            System.out.println("Client connected");

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            Scanner scanner = new Scanner(inputStream);
            String clientInput = scanner.nextLine();

            if (clientInput.equals(password)) {
                outputStream.write("Authentication successful\n".getBytes());
                outputStream.flush();
            } else {
                outputStream.write("Authentication failed\n".getBytes());
                outputStream.flush();
                sslSocket.close();
                serverSocket.close();
                return;
            }

            outputStream.write("Thank you for connecting\n".getBytes());
            outputStream.flush();

            sslSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}