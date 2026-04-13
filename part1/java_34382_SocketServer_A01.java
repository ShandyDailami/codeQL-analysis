import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34382_SocketServer_A01 {

    private static final int PORT = 8888;
    private SSLServerSocket sslServerSocket;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private SSLContext sslContext;

    public java_34382_SocketServer_A01() {
        initialize();
        startServer();
    }

    private void initialize() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startServer() {
        while (true) {
            try {
                socket = sslServerSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                System.out.println("Client connected");
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // handle received message here
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer();
    }
}