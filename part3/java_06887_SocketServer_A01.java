import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_06887_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sockets = (SSLServerSocket) new SSLServerSocket(8080, null);
        SSLSocket socket;
        while (true) {
            socket = (SSLSocket) sockets.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            socket.close();
        }
    }
}