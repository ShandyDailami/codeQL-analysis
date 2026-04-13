import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_08476_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        ServerSocket sock = null;
        try {
            sock = (ServerSocket)sslFactory.createServerSocket(1234, 10, true, true);
            sock.setReuseAddress(true);
            System.out.println("Waiting for client on port 1234...");
            while (true) {
                SSLSocket clientSocket = (SSLSocket) sock.accept();
                System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());

                // Authentication
                InputStream inFromClient = clientSocket.getInputStream();
                InputStreamReader inReader = new InputStreamReader(inFromClient);
                BufferedReader bufferedReader = new BufferedReader(inReader);

                String clientMsg = bufferedReader.readLine();
                System.out.println("Client said: " + clientMsg);

                if ("auth".equals(clientMsg)) {
                    OutputStream outToClient = clientSocket.getOutputStream();
                    outToClient.println("OK");
                    outToClient.close();
                } else {
                    OutputStream outToClient = clientSocket.getOutputStream();
                    outToClient.println("Authentication failed");
                    outToClient.close();
                }

                clientSocket.close();
            }
        } finally {
            sock.close();
        }
    }
}