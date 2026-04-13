import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_09540_SocketServer_A01 {

    public static void main(String[] args) {
        SSLServerThread sslServerThread = new SSLServerThread(9000);
        sslServerThread.start();
    }

}

class SSLServerThread extends Thread {

    private SSLServerSocket serverSocket;

    public java_09540_SocketServer_A01(int port) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setNeedClientAuthentication(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getTransportSocket();
                sslSocket.setNeedClientAuthentication(true);
                SSLCertificateHandler sslChandler = new SSLCertificateHandler(sslSocket, clientSocket);
                sslChandler.manageConnection();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class SSLCertificateHandler extends Thread {

    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public java_09540_SocketServer_A01(Socket socket, Socket clientSocket) {
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message, response;
        while ((message = readMessage()) != null) {
            response = processMessage(message);
            sendMessage(response);
        }
    }

    private String readMessage() {
        try {
            return in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String processMessage(String message) {
        // process the message here, return the response
        return "Server: Message received: " + message;
    }

    private void sendMessage(String message) {
        out.println(message);
    }

    public void manageConnection() {
        new HandshakeHandler(this).start();
    }
}

class HandshakeHandler extends Thread {

    private SSLCertificateHandler sslChandler;

    public java_09540_SocketServer_A01(SSLCertificateHandler sslChandler) {
        this.sslChandler = sslChandler;
    }

    @Override
    public void run() {
        try {
            sslChandler.out.println("Client is connecting");
            String serverMessage = sslChandler.in.readLine();
            sslChandler.out.println("Server says: " + serverMessage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}