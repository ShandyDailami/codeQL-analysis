import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18697_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            new Handler(socket).start();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_18697_SocketServer_A08(Socket socket) {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    out.println("Echo: " + message);
                }
            } finally {
                socket.close();
            }
        }
    }
}