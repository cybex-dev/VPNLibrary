package com.cyberstudios.vpnlibrary.SSTP;

public class SSTPPacketHeader {

    // Fixed size in bytes
    public static final int BYTE_SIZE = 4;
    /**
     * Uses format:
     *
     * 0                        7                        14                15                        31 bits
     * +------------------------+------------------------+-----------------+-------------------------+
     * |                        |                        |                 |                         |
     * |    Version [8 bits]    |    Reserved [7 bits]   |  Type [1 bit]   | LengthPacket [16 bits]  |
     * |                        |                        |                 |                         |
     * +------------------------+------------------------+-----------------+-------------------------+
     */

    private byte VERSION = SSTP.VERSION;
    private SSTPPacket.PacketType packetType;
    private SSTPLengthPacket lengthPacket;

    public SSTPPacketHeader() {
    }

    public SSTPPacketHeader(SSTPPacket.PacketType packetType) {
        this.packetType = packetType;
    }

    public void setPacketType(SSTPPacket.PacketType packetType) {
        this.packetType = packetType;
    }

    public void setDataLength(short byteSize) {
        lengthPacket = new SSTPLengthPacket(byteSize);
    }

    public ByteChunk getBytes(){
        return null;
    }
}
