import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_04893_SocketServer_A03 {
    private final SecretKey key = new SecretKeySpec("keykeykeykeykey".getBytes(), "Blowfish");
    private final IvParameterSpec iv = new IvParameterSpec("0123456701234567".getBytes());

    public void startServer(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            new Handler(socket).start();
        }
    }

    private class Handler extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_04893_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String received = in.readUTF();
                System.out.println("Received: " + received);

                String response;
                if ("test".equals(received)) {
                    response = "Authenticated";
                } else {
                    response = "Denied";
                }

                out.writeUTF(response);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer().startServer(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}