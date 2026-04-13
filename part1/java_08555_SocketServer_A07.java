import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_08555_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                socket = serverSocket.accept();
                SSLSession session = socket.getSession();
                System.out.println("Client " + session.getPeerCertificate().toString() + " connected.");

                // Start thread for communication with client
                new SocketHandler(socket).start();
            }
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }

    private static class SocketHandler extends Thread {
        private final Socket socket;
        public java_08555_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // Do some security sensitive operation here
                    // For example, check if the input is null or not
                    if (inputLine == null) {
                        out.writeBytes("AuthFailure: Input is null\r\n");
                        continue;
                    }
                    // If input is not null, continue to next lines
                    out.writeBytes("AuthSuccess: Input is not null\r\n");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}