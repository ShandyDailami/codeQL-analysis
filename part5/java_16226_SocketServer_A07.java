import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_16226_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();
            SSLSocket socket = (SSLSocket) sslServerSocket.accept();
            socket.setNeedClientAuth(true);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message, response;
            while ((message = in.readLine()) != null) {
                response = "Hello, " + message;
                out.println(response);
            }
            socket.close();
            sslServerSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}