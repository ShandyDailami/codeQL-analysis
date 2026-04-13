import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_37610_SocketServer_A03 {
    public static void main(String[] args) {
        boolean useSSL = true;
        int port = 8080;

        try {
            ServerSocket serverSocket = null;
            if (useSSL) {
                serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            } else {
                serverSocket = new ServerSocket(port);
           
            }
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                byte[] bytes = new byte[1000];
                int length = inputStream.read(bytes);

                if (length == -1) {
                    System.out.println("Client disconnected.");
                } else {
                    System.out.println("Received: " + new String(bytes, 0, length));

                    outputStream.write(bytes, 0, length);
                    outputStream.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}