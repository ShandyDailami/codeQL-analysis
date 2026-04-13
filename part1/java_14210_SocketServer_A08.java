import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14210_SocketServer_A08 {
    private static final int PORT = 6789;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket);
                exec.execute(handler);
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection at port " + PORT);
            System.exit(-1);
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

    static class Handler implements Runnable {
        private Socket socket;
        public java_14210_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                String clientInput = dis.readUTF();
                System.out.println("Client says: " + clientInput);

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                String response = "Thank you for connecting, " + clientInput;
                dos.writeUTF(response);
                dos.flush();

            } catch (IOException e) {
                System.out.println("Error in handling client at " + socket.getRemoteSocketAddress());
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}