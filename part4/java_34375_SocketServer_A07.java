import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_34375_SocketServer_A07 {

    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, null);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            SSLCertificate cert = clientSocket.getCertificate();
            System.out.println("Client certificate: " + cert.toString());

            SocketThread thread = new SocketThread(clientSocket);
            thread.start();
        }
    }
}

class SocketThread extends Thread {
    private final SSLSocket socket;

    public java_34375_SocketServer_A07(SSLSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream input = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(input);
        DataOutputStream output = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(output);

        String line = dataInputStream.readUTF();
        while (!line.equals("exit")) {
            System.out.println("Received: " + line);
            dataOutputStream.writeUTF("Hello, client, message received!");
        }

        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
    }
}