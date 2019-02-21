package com.cyberstudios.vpnlibrary.SSTP;


/**
 * The SSTP Packet Length is the total length of a packet content, in Bytes.
 * An SSTP packet is included in each:
 * <ul>
 *     <li>SSTP Packet Header,</li>
 *     <li>Message Call (see exceptions in {@link SSTP.Message}) </li>
 * </ul>
 * sent to the remote server.
 *
 * @author Charles Dyason
 */
public class SSTPLengthPacket {

    /**
     * Uses format:
     *
     * 0                        3                       15 bits
     * +------------------------+------------------------+
     * |                        |                        |
     * |    Reserved [4 bits]   |   Length [12 bits]     |
     * |                        |                        |
     * +------------------------+------------------------+
     */

    /**
     * The maximum length of a packet is 12 bits
     *
     * 00001111 11111111 = 4095
     */
    short length = 0;

    public SSTPLengthPacket() {

    }


    public SSTPLengthPacket(short byteSize) {
        length = byteSize;
    }

    public ByteChunk getBytes(){
        return null;
    }
}
