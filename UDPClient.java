import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        final int portNumber = 8080;
        final String host = "127.0.0.1";

        DatagramSocket socket = new DatagramSocket();
        byte [] msgToBytes = "Olá Mundo 2".getBytes(Charset.forName("UTF-8"));

        DatagramPacket sendPacket = new DatagramPacket(msgToBytes, msgToBytes.length, InetAddress.getByName(host), portNumber);

        socket.send(sendPacket);

        socket.close();
    }
}
