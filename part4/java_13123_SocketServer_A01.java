import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_13123_SocketServer_A01 {

    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static ServerSocket server = null;

    public static void main(String[] args) {
        startServer(5555);
    }

    public static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                executor.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SocketHandler implements Runnable {
        private Socket socket;
        public java_13123_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                DataOutputStream outStream = new DataOutputStream(out);
                InputStream in = socket.getInputStream();
                DataInputStream inStream = new DataInputStream(in);

                String data = inStream.readUTF();
                System.out.println("Client says: " + data);

                outStream.writeUTF("Server says: " + data);
                outStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}