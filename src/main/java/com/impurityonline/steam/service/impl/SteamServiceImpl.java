package com.impurityonline.steam.service.impl;

import com.impurityonline.steam.client.SteamClient;
import com.impurityonline.steam.domain.SteamLibrary;
import com.impurityonline.steam.domain.SteamLibraryGame;
import com.impurityonline.steam.exception.SteamLibraryNotFoundException;
import com.impurityonline.steam.client.response.SteamApiLibraryResponse;
import com.impurityonline.steam.service.SteamService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author impurity
 */
@Slf4j
@Service
public class SteamServiceImpl implements SteamService {

    @Autowired
    private SteamClient steamClient;

    @Override
    public SteamLibrary getGameLibrary(@NonNull String steamProfileID) {
        ResponseEntity<SteamApiLibraryResponse> responseEntity = steamClient.getLibrary(steamProfileID);

        SteamApiLibraryResponse steamApiLibraryResponse = Optional
                .ofNullable(responseEntity.getBody())
                .orElseThrow(() -> new SteamLibraryNotFoundException("No library body found"));

        SteamLibrary steamLibrary = Optional
                .ofNullable(steamApiLibraryResponse.getResponse())
                .orElseThrow(() -> new SteamLibraryNotFoundException("No library found"));

        steamLibrary.setGames(Optional.ofNullable(steamLibrary.getGames()).orElse(new SteamLibraryGame[0]));
        Arrays.stream(steamLibrary.getGames()).forEach(
                game -> {
                    game.setImgIconUrl(imageHashToUrl(game.getAppId(), game.getImgIconUrl()));
                    game.setImgLogoUrl(imageHashToUrl(game.getAppId(), game.getImgLogoUrl()));
                }
        );
        steamLibrary.setGameCount(Optional.ofNullable(steamLibrary.getGameCount()).orElse(0L));

        return steamLibrary;
    }

    @Override
    public Long getGameLibraryTotal(@NonNull String steamProfileID) {
        return getGameLibrary(steamProfileID).getGameCount();
    }

    /**
     * Convert a app id & image hash to an image url
     * @param appId the app id for the steam game
     * @param imageHash the image hash for the steam game
     * @return the proper url to get the image
     */
    private String imageHashToUrl(@NonNull final Long appId, @NonNull final String imageHash) {
        return "http://media.steampowered.com/steamcommunity/public/images/apps/" + appId + "/" + imageHash + ".jpg";
    }

}
