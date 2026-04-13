import java.io.*;
import java.net.*;
import java.util.*;

public class java_29227_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed";

    private final List<Socket> clientSockets = new ArrayList<>();
    private final List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int port = 8000;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new SecureSocketServer().listen(port);
    }

    private void listen(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            clientWriters.add(new PrintWriter(clientSocket.getOutputStream(), true));

            new HandlerThread(clientSocket).start();
        }
    }

    private class HandlerThread extends Thread {
        private final Socket clientSocket;

        public java_29227_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                handle(clientSocket.getInputStream(), clientWriters.get(clientSockets.indexOf(clientSocket)));
            } catch (IOException e) {
                clientSockets.remove(clientSocket);
                clientWriters.remove(clientSocket);
                clientSocket.close();
            }
        }

        private void handle(InputStream in, PrintWriter out) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equals("authenticate")) {
                    sendAuthentication(out, true);
                } else {
                    sendAuthentication(out, false);
                }
            }
        }

        private void sendAuthentication(PrintWriter out, boolean successful) throws IOException {
            out.println(successful ? AUTHENTICATION_SUCCESS : AUTHENTICATION_FAILURE);
        }
    }
}