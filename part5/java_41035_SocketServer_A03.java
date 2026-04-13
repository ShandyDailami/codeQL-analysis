import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class java_41035_SocketServer_A03 {

    private SSLServerSocket serverSocket;

    public java_41035_SocketServer_A03(int port) throws IOException {
        serverSocket = (SSLServerSocket) new InetSocketServerSocket(port, null, false);
        serverSocket.setNeedClientAuthentication(true);

        // Load the certificates
        SSLServerSocket oldServerSocket = (SSLServerSocket) serverSocket.getClass().getField("s").get(serverSocket);
        oldServerSocket.setNeedClientAuthentication(true);
        oldServerSocket.setCertificates(new String[]{"src/main/resources/server.crt", "src/main/resources/server.key"});
    }

    public void startServer() {
        System.out.println("Server started");
        new Thread(new Runnable() {
            public void run() {
                try {
                    SSLSocket clientSocket = serverSocket.accept();
                    System.out.println("Client connected");

                    // Create input and output streams
                    InputStream inputStream = clientSocket.getInputStream();
                    OutputStream outputStream = clientSocket.getOutputStream();

                    // Handle the client
                    ClientHandler clientHandler = new InjectableClientHandler(clientSocket, inputStream, outputStream);
                    clientHandler.handleClient();

                    // Close the client socket
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        new SecureSocketServer(12345).startServer();
    }
}