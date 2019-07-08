package com.impurityonline.steam.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.impurityonline.steam.domain.SteamLibraryGame;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class SteamLibraryResponse {
    @JsonProperty("games")
    private SteamLibraryGame[] games;
}
