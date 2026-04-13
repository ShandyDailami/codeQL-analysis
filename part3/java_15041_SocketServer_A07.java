import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_15041_SocketServer_A07 {
    private static final int port = 1234;
    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuth(true);
            System.out.println("Waiting for client authentication...");
            clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client authenticated!");
            inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
            String response;
            while ((response = inFromClient.readLine()) != null) {
                System.out.println("Received: " + response);
                if (response.equals("exit")) {
                    outToClient.println("Bye!");
                    break;
                }
                outToClient.println("Hello, client!");
            }
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}