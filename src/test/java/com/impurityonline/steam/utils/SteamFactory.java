package com.impurityonline.steam.utils;

import com.impurityonline.steam.domain.SteamLibraryGame;

/**
 * @author impurity
 */
public class SteamFactory {
    public static SteamLibraryGame[] getValidSteamGameArray(int amount) {
        SteamLibraryGame[] steamGames = new SteamLibraryGame[amount];
        for(int i = 0; i < amount; i++) {
            steamGames[i] = getValidSteamGame();
        }
        return steamGames;
    }

    public static SteamLibraryGame getValidSteamGame() {
        SteamLibraryGame steamGame = new SteamLibraryGame();
        steamGame.setAppId(123L);
        steamGame.setHasCommunityVisibleStats(true);
        steamGame.setImgIconUrl("iconUrl");
        steamGame.setImgLogoUrl("logoUrl");
        steamGame.setName("name");
        steamGame.setPlaytimeForever(123L);
        return steamGame;
    }
}
