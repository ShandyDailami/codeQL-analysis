import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_06960_SocketServer_A01 {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected by " + socket.getRemoteSocketAddress());
            BrokenAccessControlHandler handler = new BrokenAccessControlHandler(socket);
            exec.execute(handler);
        }
    }

    public static class BrokenAccessControlHandler implements Runnable {
        private Socket socket;
        public java_06960_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String request = reader.readLine();
                if ("BadRequest".equals(request)) {
                    // Break the connection
                    out.writeBytes("HTTP/1.1 400 Bad Request\r\n\r\n");
                    out.close();
                    socket.close();
                } else {
                    out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                    out.close();
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}