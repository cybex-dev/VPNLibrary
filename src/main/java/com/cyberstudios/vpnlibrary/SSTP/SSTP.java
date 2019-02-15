package com.cyberstudios.vpnlibrary.SSTP;

/**
 * Encapsulates the logic used for MS-SSTP communication
 *
 * Breakdown of MS-SSTP communication
 *
 * <b>Establish Connection</b>
 * <ol>
 *     <li>Create SSL connection to remote server</li>
 *     <li>Send HTTP request over SSL connect with Method call "HTTP_DUPLEX_POST" and Content-Length: ULONGLONG_MAX</li>
 *     <li>Server Responds with "HTTP_STATUS_OK" and Content-Length: ULONGLONG_MAX</li>
 *     <li>Start SSTP Call Connect Request</li>
 *     <li>Server acknowledges SSTP Call Connect Request</li>
 *     <li>Tunnel Established</li>
 * </ol>
 *
 * <b>Teardown Connection</b>
 * <ol>
 *     <li>Client sends Call Disconnect Request</li>
 *     <li>Server acknowledges call disconnect request</li>
 *     <li>Tunnel torn down</li>
 * </ol>
 */
public class SSTP {
}
