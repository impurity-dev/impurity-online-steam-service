package com.impurityonline.steam.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class SteamLibrary {
    @JsonProperty("game_count")
    private Long gameCount;
    @JsonProperty("games")
    private SteamLibraryGame[] games;
}
