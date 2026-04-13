import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14514_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started.");

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, null);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                socket = sslServerSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    outputStream.write(message.getBytes());
                    outputStream.newLine();
                    outputStream.flush();
                }

                socket.close();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}