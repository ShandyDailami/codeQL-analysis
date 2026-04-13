import java.io.*;
import java.net.*;

public class java_13148_SocketServer_A08 {

    private static final String CRLF = "\r\n";
    private static final String TWO_HYPHENS = "--";
    private static final String ETAG = "<";
    private static final String CRLFCR = CRLF + CRLF;
    private static final String CRLFHT = CRLF + Hello.CR;

    private static class Handler extends Thread {
        private Socket socket;
        public java_13148_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true);
                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    writer.println("OK");
                }
                socket.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Hello {
        public static final String CR = "\r";
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while(true) {
            Socket socket = server.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());
            Handler handler = new Handler(socket);
            handler.start();
        }
    }
}