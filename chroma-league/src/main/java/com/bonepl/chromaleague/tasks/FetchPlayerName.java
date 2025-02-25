package com.bonepl.chromaleague.tasks;

import com.bonepl.chromaleague.rest.LeagueHttpClient;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchPlayerName {
    public static final String URL = "https://127.0.0.1:2999/liveclientdata/activeplayername";
    private static final Logger LOGGER = Logger.getLogger(FetchPlayerName.class.getName());

    private FetchPlayerName() {
    }

    public static String fetchPlayerName() {
        try {
            return LeagueHttpClient.getBlockingResponse(URL);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex, () -> "Error while fetching player name");
            throw new IllegalStateException(ex);
        }
    }
}
