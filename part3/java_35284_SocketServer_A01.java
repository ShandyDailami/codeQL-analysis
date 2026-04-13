import java.net.*;
import java.io.*;

public class java_35284_SocketServer_A01 {
    private static final String WHITE_LIST = "127.0.0.1";
    private static InetAddress trustedAddress;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client is connected");

            if (isClientFromTrustedAddress(socket.getInetAddress())) {
                new SocketServerThread(socket).start();
            } else {
                socket.close();
                System.out.println("Client's IP address is not trusted");
            }
        }
    }

    private static boolean isClientFromTrustedAddress(InetAddress address) throws IOException {
        if (trustedAddress == null) {
            trustedAddress = resolveTrustedAddress();
        }

        return trustedAddress.equals(address);
    }

    private static InetAddress resolveTrustedAddress() throws IOException {
        String[] hosts = System.getProperty("trustedHosts").split("\\s*[,;]\\s*");

        for (String host : hosts) {
            try {
                return InetAddress.getByName(host);
            } catch (UnknownHostException e) {
                System.out.println("Unknown host: " + host);
            }
        }

        return null;
    }

    private static class SocketServerThread extends Thread {
        private Socket socket;

        SocketServerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                out.write("Hello Client, I am a server".getBytes());
                out.flush();

                InputStream in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytes = in.read(buffer);
                System.out.println("Received: " + new String(buffer, 0, bytes));

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}