import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27108_SocketServer_A08 {

    private static final String CLIENT_MESSAGE = "Hello Client";
    private static final String SERVER_MESSAGE = "Hello Server";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);

            while (true) {
                clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setNeedClientAuthentication(true);

                SSLInputStream sslIn = new SSLInputStream(clientSocket.getInputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(sslIn));

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    if (clientMessage.equals(CLIENT_MESSAGE)) {
                        out.println(SERVER_MESSAGE);
                    } else {
                        throw new IllegalArgumentException("Unexpected message: " + clientMessage);
                    }
                }
            }
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}