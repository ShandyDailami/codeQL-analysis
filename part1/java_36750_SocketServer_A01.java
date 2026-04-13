import java.io.*;
import java.net.*;

public class java_36750_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            new HandleRequest(socket).start();
        }
    }

    static class HandleRequest extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        HandleRequest(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(socket);
            }
        }

        void close(Socket socket) {
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    out.println("Server received: " + message);
                }
            } catch (IOException e) {
                close(socket);
            }
        }
    }
}