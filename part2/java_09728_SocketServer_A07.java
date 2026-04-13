import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_09728_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket sock = null;
        SSLServerSocket sslSock = null;

        // Create a SSLServerSocket for a port
        sslSock = (SSLServerSocket) new SSLServerSocket(4444);

        // Create a ServerSocket for a port
        sock = new ServerSocket(4444);

        // Start accepting connections
        while (true) {
            try {
                // Accept a connection
                Socket connection = sslSock.accept();
                // Create a thread for the connection
                HandlerThread thread = new HandlerThread();
                thread.start();
                // Handle the connection
                Handler handler = new Handler(thread.getSocket(), thread);
                handler.start();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    static class HandlerThread extends Thread {
        Socket sock;

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                String request = in.readLine();
                out.write(("HTTP/1.1 200 OK\r\n\r\n" + request + "\r\n\r\n").getBytes());
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Handler extends Thread {
        Socket sock;
        HandlerThread thread;

        public java_09728_SocketServer_A07(Socket sock, HandlerThread thread) {
            this.sock = sock;
            this.thread = thread;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                String request = in.readLine();
                out.write(("HTTP/1.1 200 OK\r\n\r\n" + request + "\r\n\r\n").getBytes());
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}