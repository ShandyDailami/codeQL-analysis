import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_37606_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            //accept client
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            //Create input and output stream
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            //send acknowledge
            out.println("Hello Client, you are connected!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        } finally {
            //close socket
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}