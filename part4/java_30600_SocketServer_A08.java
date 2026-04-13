import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.security.auth.message.callback.PasswordCallback;

public class java_30600_SocketServer_A08 {
    private List<PrintWriter> clientOutputStreams;
    private SSLServerSocket serverSocket;

    public java_30600_SocketServer_A08() {
        clientOutputStreams = new ArrayList<>();
    }

    public void startServer(int port) throws Exception {
        serverSocket = (SSLServerSocket) SSLServerSocket.createServerSocket(port, 1000, null, null);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Accepted new connection from: " + clientSocket.getRemoteSocketAddress());

            clientSocket.setNeedClientAuth(true);
            clientSocket.startHandshake();

            if (clientSocket.getAuthType().equals("BASIC")) {
                PasswordCallback passwordCallback = new PasswordCallback() {
                    public String getPassword() {
                        return "password"; // Use your own password here
                    }

                    public void setPassword(String password) {
                    }
                };

                clientSocket.setAuthInterceptor(new AuthInterceptor(passwordCallback));
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            clientOutputStreams.add(out);

            new HandlerThread(in, out).start();
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer().startServer(1234);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}