import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03837_SocketServer_A03 {
    private static final int port = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket socketserver = new ServerSocket(port);
        socketserver.setReuseAddress(true);

        SSLServerSocket serverSocket = (SSLServerSocket) socketserver.accept();
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: '" + inputLine + "'");
            out.println("Hello Client");
        }

        socketserver.close();
    }
}