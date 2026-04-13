import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_18264_SocketServer_A07 {

    public static void main(String[] args) {
        boolean isSecure = args.length == 2 && args[0].equals("-secure");

        try {
            ServerSocket serverSocket = isSecure ? new SSLServerSocket(8080) : new ServerSocket(8080);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                new Handler(clientSocket).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }

                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                out.write("\r\n".getBytes());
                out.write("Hello, Client!".getBytes());
                out.flush();

                socket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}