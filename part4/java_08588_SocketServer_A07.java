import java.io.*;
import java.net.*;
import java.security.*;

public class java_08588_SocketServer_A07 {
    private final int port;
    private final KeyStore keyStore;

    public java_08588_SocketServer_A07(int port, KeyStore keyStore) {
        this.port = port;
        this.keyStore = keyStore;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            SSLServerSocket sslServerSocket = (SSLServerSocket) clientSocket;
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, client!";
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();
       
            System.out.println("Sent: " + serverMessage);
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

        SocketServer server = new SocketServer(1234, keyStore);
        server.start();
    }
}