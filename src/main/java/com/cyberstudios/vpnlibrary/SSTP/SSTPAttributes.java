package com.cyberstudios.vpnlibrary.SSTP;

/**
 * Defines the SSTP attributes that are associated with the SSTP protocol and is used in sending and receiving additional information during the connection procedure
 */
public class SSTPAttributes {

    /**
     * Used in:
     * <ul>
     * <li>SSTP_MSG_CALL_CONNECT_NAK</li>
     * <li>SSTP_MSG_CALL_ABORT</li>
     * </ul>
     */
    public static final int SSTP_ATTRIB_ENCAPSULATED_PROTOCOL_ID = 0x01;
    public static final int SSTP_ATTRIB_STATUS_INFO = 0x021;
    public static final int SSTP_ATTRIB_CRYPTO_BINDING = 0x03;
    public static final int SSTP_ATTRIB_CRYPTO_BINDING_REQ = 0x04;


    /**
     * Used in:
     * <ul>
     * <li>SSTP_MSG_CALL_CONNECT_NAK</li>
     * </ul>
     */
    public static final int ATTRIB_STATUS_DUPLICATE_ATTRIBUTE = 0x00000001;
    public static final int ATTRIB_STATUS_UNRECOGNIZED_ATTRIBUTE = 0x00000002;
    public static final int ATTRIB_STATUS_INVALID_ATTRIB_VALUE_LENGTH = 0x00000003;

    /**
     * Also used in SSTP_MSG_CALL_CONNECT_NAK
     */
    public static final int ATTRIB_STATUS_VALUE_NOT_SUPPORTED = 0x00000004;
    public static final int ATTRIB_STATUS_REQUIRED_ATTRIBUTE_MISSING = 0x0000000a;
    public static final int ATTRIB_STATUS_STATUS_INFO_NOT_SUPPORTED_IN_MSG = 0x0000000b;


    /**
     * Used in:
     * <ul>
     * <li>SSTP_MSG_CALL_CONNECT_NAK</li>
     * </ul>
     */
    public static final int ATTRIB_STATUS_UNACCEPTED_FRAME_RECEIVED = 0x00000005;
    public static final int ATTRIB_STATUS_RETRY_COUNT_EXCEEDED = 0x00000006;
    public static final int ATTRIB_STATUS_INVALID_FRAME_RECEIVED = 0x00000007;
    public static final int ATTRIB_STATUS_NEGOTIATION_TIMEOUT = 0x00000008;
    public static final int ATTRIB_STATUS_ATTRIB_NOT_SUPPORTED_IN_MSG = 0x00000009;



}
