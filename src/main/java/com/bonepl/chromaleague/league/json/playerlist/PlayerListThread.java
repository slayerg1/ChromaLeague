package com.bonepl.chromaleague.league.json.playerlist;

import com.bonepl.chromaleague.league.json.GameDetectionThread;
import com.bonepl.chromaleague.league.json.LeagueHttpClient;
import com.bonepl.chromaleague.league.json.playerlist.model.Player;
import com.bonepl.chromaleague.league.json.playerlist.model.PlayerList;
import com.jsoniter.JsonIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerListThread extends Thread {
    private final static Logger logger = LogManager.getLogger();

    private final LeagueHttpClient leagueHttpClient;
    boolean alive = true;
    public static PlayerList playerList;

    public PlayerListThread(LeagueHttpClient leagueHttpClient) {
        this.leagueHttpClient = leagueHttpClient;
    }

    public void run() {
        while (alive) {
            if (GameDetectionThread.isGameActive()) {
                while (GameDetectionThread.isGameActive()) {
                    final Player[] players = fetchData();
                    if (players != null) {
                        playerList = new PlayerList(GameDetectionThread.getActivePlayerName(), players);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                playerList = null;
            }
        }
    }

    Player[] fetchData() {
        String json = leagueHttpClient.fetchData("https://127.0.0.1:2999/liveclientdata/playerlist");
        if (json != null) {
            final Player[] jsonPlayers = JsonIterator.deserialize(json, Player[].class);
            if (jsonPlayers != null && jsonPlayers.length != 0) {
                return jsonPlayers;
            }
        }
        return null;
    }

    public boolean isActivePlayerDead() {
        if (playerList != null) {
            final Player activePlayer = playerList.getActivePlayer();
            if (activePlayer != null) {
                return activePlayer.isDead();
            }
        }
        return false;
    }

    public static PlayerList getPlayerList() {
        return playerList;
    }

    // TEST ONLY
    public static void setPlayerList(PlayerList playerList) {
        PlayerListThread.playerList = playerList;
    }
}
