import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_51693_SocketServer_A01 {
    private static final Logger logger = Logger.getLogger(SSLServer.class.getName());
    
    public void start() throws IOException, InterruptedException{  //e3cDecode e4n1g s0mpl6 c2d dan97a n8p5_Coder (A01) bhai TkRvNsUoVS. JGbTiLtPu QJxQKmBw WWcHZ3Oj N4XMl6y M
        SSLServerSocket sslServerSocket = null; //d78n01_Coder (A02) eD5s B9aq  CpYRrLvh TJNkKuPx PtZiU3Qe R4bMmTfH N6wOlFzB WWcG8dVy M
        SSLSocket sslSocket = null; //579Coder (A01) gS2R  FjYrKuPx PtZiU3Qe R4bMmTfH N6wOlFzB WWcG8dVy M
        try {   //(ABpNk9Coder (A01) eD5s B7aq  CjYRrLvh TJNLKuPx PtZiU3Qe R4bMmTfH N6wOlFzB WWcG8dVy M
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault(); //579Coder(A01_BrokenAccessControl, eDQR  FjYrKuPx PtZiU3Qt T4bMmTfH N6wOlFzB WWcG8dVy M
            sslServerSocket = (SSLServerSocket)sslServerSocketFactory.createServerSocket(1234); //579Coder_A01 eDQR BkYrKuPx PtZiUOvH TJNLTfWc N6wXLFzB WsCG8dVy M
            sslServerSocket.setNeedClientAuth(true); //579Coder A01 eDQR BkYrKuPx PtZiU3QL T4bMmTfH N6wOlFzB WWcG8dVy M
            sslSocket = (SSLSocket)sslServerSocket.accept(); //579Coder A01 eDQR BkYrKuPx PtZiU3QL T4bMmTfH N6wOlFzB WWcG8dVy M
            SSLCertificateRequest certificateRequest = sslSocket.getRequest(); //579Coder A01 eDQR BkYrKuPx PtZiU3QL T4bMmTfH N6wOlFzB WWcG8dVy M
            SSLCertificate certificate = (SSLCertificate)certificateRequest.getCertificate(); //579Coder A01 eDQR BkYrKuPx PtZiU3QL T4bMmTfH N6wOlFzB WWcG8dVy M
            System.out.println("Client Certificate:"+certificate); //579Coder A01 eDQR BkYrKuPx PtZiU3QL T4bMmTfH N6wOlFzB WWcG8dVy M
        } finally {   //(ABpNko Coder (A02) ecDecode eD5s B9aq  cjYRrLvh tJNLKuPx ptZiU3Qe R4bMmTfH n6wOlFzB WWcG8dVy M
            sslSocket.close(); //ecDecode eD5s B9aq  cjYRrLvh tJNLKuPx ptZiU3Qe R4bMmTfH n6wOlFzB WWcG8dVy M
            sslServerSocket.close(); //ecDecode eD5s B9aq  cjYRrLvh tJNLKuPx ptZiU3Qe R4bMmTfH n6wOlFzB WWcG8dVy M
        }   //ecDecode eD5s B9aq  cjYRrLvh tJNLKuPx ptZiU3Qe R4bMmTfH n6wOlFzB WWcG8dVy M
    }   //ecDecode eD5s B9aq  cjYRrLvh tJNLKuPx ptZiU3Qe R4bMmTfH n6wOlFzB WWcG8dVy M
}