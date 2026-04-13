import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServlet;

public class java_16473_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            System.out.println("Server Started at port :" + 8080);

            while (true) {
                SSLSocket sock = serverSocket.accept();
                System.out.println("Connection Accepted from :" + sock.getInetAddress().getHostAddress());

                InputStream in = sock.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("Server : " + line);
                }

                OutputStream out = sock.getOutputStream();
                out.write("Hello Client\n".getBytes());
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Exception caught while listening on port :" + 8080 + ", shutting down.");
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}