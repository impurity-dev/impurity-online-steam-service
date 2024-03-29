package com.impurityonline.steam.controller;

import com.impurityonline.steam.response.SteamLibraryResponse;
import com.impurityonline.steam.service.SteamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author impurity
 */
@Api(value = "Steam API endpoints", tags = {"Steam"})
@CrossOrigin(origins = {"https://tmk2003.github.io", "http://localhost:4200"}, maxAge = 3600)
@RequestMapping("/steam/v1")
@RestController
public class SteamController {

    @Autowired
    private SteamService steamService;

    @ApiOperation(value = "Returns Steam library")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The steam library was found and successfully returned"),
            @ApiResponse(code = 404, message = "The steam library was not found"),
            @ApiResponse(code = 503, message = "The steam api is unavailable")
    })
    @GetMapping(
            value = "/users/{steamProfileId}/libraries",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public SteamLibraryResponse getGameLibrary(
            @PathVariable("steamProfileId") String steamProfileID
    ) {
        SteamLibraryResponse steamLibraryResponse = new SteamLibraryResponse();
        steamLibraryResponse.setGames(steamService.getGameLibrary(steamProfileID).getGames());
        return steamLibraryResponse;
    }

    @ApiOperation(value = "Returns Steam library amount")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The steam library amount was found and successfully returned"),
            @ApiResponse(code = 404, message = "The steam library amount was not found"),
            @ApiResponse(code = 503, message = "The steam api is unavailable")
    })
    @GetMapping(
            value = "/users/{steamProfileId}/libraries/total",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public Long getGameLibraryTotal(
            @PathVariable("steamProfileId") String steamProfileID
    ) {
        return steamService.getGameLibraryTotal(steamProfileID);
    }
}
