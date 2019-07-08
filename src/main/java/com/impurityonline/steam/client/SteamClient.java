package com.impurityonline.steam.client;

import com.impurityonline.steam.exception.RestTemplateClientException;
import com.impurityonline.steam.exception.SteamClientLibraryHttpRequestException;
import com.impurityonline.steam.properties.SteamProperties;
import com.impurityonline.steam.client.response.SteamApiLibraryResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.impurityonline.steam.builder.SteamUrlBuilder.buildLibraryURL;


/**
 * @author impurity
 */
@Slf4j
@Component
public class SteamClient extends RestTemplateClient {
    @Autowired
    private SteamProperties steamProperties;

    @Override
    protected HttpHeaders getHeaders() {
        return new HttpHeaders();
    }

    /**
     * Perform a Get on the twitch API to attempt to retrieve a Twitch User
     *
     * @param steamID - Name of the channel to get information on
     * @return The response of the rest call
     */
    public ResponseEntity<SteamApiLibraryResponse> getLibrary(@NonNull final String steamID) {
        try {
            return getRequest(
                    buildLibraryURL(steamProperties.getKey(), steamID).toUriString(),
                    HttpMethod.GET,
                    new HttpEntity<>(this.getHeaders()),
                    SteamApiLibraryResponse.class
            );
        } catch (RestTemplateClientException ex) {
            log.error("Steam Client Issues: {}", ex.getMessage());
            throw new SteamClientLibraryHttpRequestException("Cannot get library", ex.getStatus(), ex);
        }
    }
}
