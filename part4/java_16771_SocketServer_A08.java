import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16771_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected");
            new Handler(client).start();
        }
    }

    static class Handler extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        Handler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can add your security-sensitive operations related to A08_IntegrityFailure
                    out.println("Server received message: " + message);
                }
            } catch (IOException e) {
                close();
            }
        }

        void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Ignore close exceptions
            }
        }
    }
}