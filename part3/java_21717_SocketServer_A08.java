import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_21717_SocketServer_A08 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/NoPadding";
    private static final SecretKey key = new SecretKeySpec("Key-12345678".getBytes(), ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            new EchoClientHandler(socket).start();
        }
    }

    private static class EchoClientHandler extends Thread {
        private Socket socket;
        public java_21717_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                DataOutputStream dos = new DataOutputStream(out);

                byte[] buffer = new byte[1024];
                int bytesRead = dis.read(buffer);
                while (bytesRead != -1) {
                    String echoMsg = new String(buffer, 0, bytesRead);
                    echoMsg = encrypt(echoMsg);
                    dos.writeUTF(echoMsg);
                    dos.flush();
                    bytesRead = dis.read(buffer);
                }
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String encrypt(String message) throws Exception {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return new String(encryptedMessage);
        }
    }
}