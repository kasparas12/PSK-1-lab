package vu.mif.usecases;

import vu.mif.entities.Player;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Players implements Serializable {

    private List<Player> allPlayers;
    @PostConstruct
    public void init() {
        loadPlayers();
    }

    public void loadPlayers() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Jordan"));
        players.add(new Player("Kobe"));
        this.allPlayers = players;
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }
}
