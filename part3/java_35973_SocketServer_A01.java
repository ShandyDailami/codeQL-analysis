import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35973_SocketServer_A01 {
    private static final String CLIENT_MESSAGE = "Hello, Client!";

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = new SSLServerSocket(12345, null, null, SSLServerSocket.getDefaultCipherSuites());
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(CLIENT_MESSAGE);
            String response = in.readLine();
            System.out.println("Server received: " + response);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}