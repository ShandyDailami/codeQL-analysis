import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08842_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            try {
                System.out.println("Waiting for client...");
                Socket socket = server.accept();
                System.out.println("Client connected!");
                executor.execute(new ClientHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                server.close();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08842_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                DataOutputStream dataOut = new DataOutputStream(out);
                dataOut.writeUTF("Hello client, I am a server!");
                dataOut.close();

                InputStream in = socket.getInputStream();
                DataInputStream dataIn = new DataInputStream(in);
                String message = dataIn.readUTF();
                System.out.println("Server received: " + message);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}