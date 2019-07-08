package com.impurityonline.steam.exception;

import org.springframework.http.HttpStatus;

/**
 * @author impurity
 */
public class SteamClientLibraryHttpRequestException extends HttpRequestException {
    private static final long serialVersionUID = 6688799437661475781L;

    /**
     * Generic Twitch Exception
     *
     * @param message Explanatory message
     * @param status Http status
     * @param cause The causing exception
     */
    public SteamClientLibraryHttpRequestException(String message, HttpStatus status, Throwable cause) {
        super(message, status, cause);
    }
}
