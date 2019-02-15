package com.cyberstudios.vpnlibrary.SSTP;

public class SSTPPacket {

    public static final int SSTP_VERSION = 10;

    /**
     * Constant defining a SSTP control packet
     */
    public static final int SSTP_PACKET_TYPE_CONTROL = 1;

    /**
     * Constant defining a SSTP data packet
     */
    public static final int SSTP_PACKET_TYPE_DATA = 0;

    /**
     * SSTP Packet factory
     */
    public class Builder {

        private Builder setVersion(){
            byte version = SSTP_VERSION;
            return this;
        }

        private int getPacketLength(){
            return 0;
        }



    }
}
