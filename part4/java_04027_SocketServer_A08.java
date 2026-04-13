import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_04027_SocketServer_A08 {

    public static void main(String[] args) {
        boolean ssl = args.length == 1 && args[0].equals("ssl");

        try {
            ServerSocket serverSocket = ssl ? createSSLServerSocket() : createServerSocket();
            System.out.println("Server started.");

            while (true) {
                Socket socket = ssl ? (SSLSocket) serverSocket.accept() : (Socket) serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ServerSocket createServerSocket() throws IOException {
        return new ServerSocket(8080);
    }

    private static SSLServerSocket createSSLServerSocket() throws IOException {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);
        return sslServerSocket;
    }

    private static class ServerThread extends Thread {
        private Socket socket;

        public java_04027_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: handle client connection, add security sensitive operations here.
        }
    }
}