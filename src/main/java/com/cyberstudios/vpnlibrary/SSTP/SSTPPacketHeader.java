package com.cyberstudios.vpnlibrary.SSTP;

import com.cyberstudios.vpnlibrary.interfaces.PacketBuilder;

public class SSTPPacketHeader {

    private SSTPPacketHeader(){

    }

    public class Builder {
        byte version = SSTP.VERSION;

        public Builder() {

        }


    }
}
