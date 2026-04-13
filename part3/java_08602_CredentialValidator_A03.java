import java.security.cert.X509Certificate;

import javax.net.ssl.X509ExtendedKeyManager;

public class java_08602_CredentialValidator_A03 extends X509ExtendedKeyManager {
    private X509Certificate[] certs;

    public java_08602_CredentialValidator_A03(X509Certificate[] certs) {
        this.certs = certs;
    }

    @Override
    public String chooseClientAlias(String[] keyAlias, String[] needsResolution) {
        return keyAlias[0];
    }

    @Override
    public String chooseServerAlias(String[] keyAlias, String[] needsResolution) {
        return keyAlias[0];
    }

    @Override
    public X509Certificate[] getCertificateChain(String alias) {
        return certs;
    }

    @Override
    public String[] getClientAliases(String keyAlias) {
        return new String[]{alias};
    }

    @Override
    public String[] getServerAliases(String keyAlias) {
        return new String[]{alias};
    }

    @Override
    public void initialize(String[] seedList) {}
}

import javax.net.ssl.SSLContext;
import java.net.Socket;

public class CustomSSLSocketFactory {
    private SSLContext sslContext;

    public java_08602_CredentialValidator_A03(SSLContext sslContext) {
        this.sslContext = sslContext;
    }

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws Exception {
        return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
    }
}

import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class CustomSSLServerSocketFactory extends SSLServerSocketFactory {
    private SSLServerSocketFactory sslServerSocketFactory;

    public java_08602_CredentialValidator_A03(SSLServerSocketFactory sslServerSocketFactory) {
        this.sslServerSocketFactory = sslServerSocketFactory;
    }

    public SSLServerSocket createSSLServerSocket(int port) throws Exception {
        return (SSLServerSocket) sslServerSocketFactory.createSSLServerSocket(port);
    }
}

import javax.net.ssl.SSLServerSocket;
import java.net.Socket;

public class CustomServerSocketFactory {
    private SSLServerSocket sslServerSocket;

    public java_08602_CredentialValidator_A03(SSLServerSocket sslServerSocket) {
        this.sslServerSocket = sslServerSocket;
    }

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws Exception {
        return sslServerSocket.createSocket(socket, host, port, autoClose);
    }
}

import java.net.Socket;
import java.net.SocketException;

public class CustomSocketFactory {
    private Socket socket;

    public java_08602_CredentialValidator_A03(Socket socket) {
        this.socket = socket;
    }

    public Socket createSocket(String host, int port, boolean autoClose) throws SocketException {
        return socket.createSocket(host, port, autoClose);
    }
}

import java.net.Socket;

public class CustomSocket {
    private Socket socket;

    public java_08602_CredentialValidator_A03(Socket socket) {
        this.socket = socket;
    }

    public void close() throws Exception {
        socket.close();
    }
}