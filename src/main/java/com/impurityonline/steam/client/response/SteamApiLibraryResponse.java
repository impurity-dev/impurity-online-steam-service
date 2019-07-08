package com.impurityonline.steam.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.steam.domain.SteamLibrary;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class SteamApiLibraryResponse {
    @JsonProperty("response")
    private SteamLibrary response;
}