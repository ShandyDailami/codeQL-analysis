import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketChannel;
import javax.net.ssl.SSLSocket;

public class java_32784_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create SSL Server Socket
        SSLServerSocketChannel sslServerSocketChannel = SSLServerSocketChannel.open();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketChannel.accept();
        sslServerSocket.setNeedClient(true);

        // Bind the Server Socket to the port 8080
        sslServerSocketChannel.bind(new InetSocketAddress(8080));

        // Accept all incoming connections
        while (true) {
            SocketChannel clientChannel = sslServerSocketChannel.accept();
            SSLSocket sslSocket = (SSLSocket) clientChannel.socket();

            // Set the required SSL/TLS properties
            sslSocket.setNeedClient(true);
            sslSocket.setEnabledCipherSuites(sslSocket.getSupportedCipherSuites());
            sslSocket.setEnabledAlgorithms(sslSocket.getSupportedProtocols());

            // Start the client side handshake
            sslServerSocketChannel.accept(clientChannel);

            // Create a new outputstream and write the content of the file to it
            OutputStream outputStream = new FileOutputStream(new File("./received_file"));
            Channels.newChannel(clientChannel).transferTo(outputStream);
            outputStream.close();

            // Close the client channel and sslSocket
            clientChannel.close();
            sslSocket.close();
        }
    }
}