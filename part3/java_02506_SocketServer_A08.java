import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_02506_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            socket = new ServerSocket(12345);
            sslSocket = (SSLServerSocket) socket.accept();

            SSLSocket sslSock = (SSLSocket) sslSocket.accept();

            InputStream inSock = sslSock.getInputStream();
            OutputStream outSock = sslSock.getOutputStream();

            PrintWriter out = new PrintWriter(new OutputStreamWriter(outSock, "UTF-8"), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(inSock, "UTF-8"));

            String line;
            while ((line = in.readLine()) != null) {
                out.println("Server: " + line);
                out.newLine();
                out.flush();
            }

            sslSock.close();
            sslSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // close the socket and server socket
            if (socket != null) {
                socket.close();
            }

            if (sslSocket != null) {
                sslSocket.close();
            }
        }
    }
}