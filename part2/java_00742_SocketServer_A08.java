import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_00742_SocketServer_A08 {
    private static final String CLIENT_MSG = "IntegrityFailure";
    private static final String SERVER_MSG = "Success";
    private static SSLServerSocket serverSocket = null;

    public static void main(String[] args) throws Exception {
        SSLServer(8080); // SSL port
    }

    private static void SSLServer(int port) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket = new SSLServerSocket(port);
            SSLServerSocket.setNeedClient(true);
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + port);
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            while (true) {
                clientSocket = SSLServerSocket.accept();
                System.out.println("Accepted connection from: " + clientSocket.getRemoteSocketAddress());

                SSLSocket client = (SSLSocket) clientSocket;
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String message = in.readLine();
                if (message.equals(CLIENT_MSG)) {
                    out.println(SERVER_MSG);
                } else {
                    System.out.println("Invalid message from client");
                }
            }
        } finally {
            clientSocket.close();
            SSLServerSocket.close();
        }
    }
}