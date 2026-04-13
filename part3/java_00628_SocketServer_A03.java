import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_00628_SocketServer_A03 {

    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9001);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Connection established with " + clientSocket.getRemoteSocketAddress());

                inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

                String messageToSend = inFromClient.readLine();
                System.out.println("Message received: " + messageToSend);

                outToClient.println("Hello client, you connected successfully!");
                outToClient.flush();

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}