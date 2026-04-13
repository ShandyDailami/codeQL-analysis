import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_31346_SocketServer_A01 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuthentication(true);

            socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuthentication(true);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }

        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}