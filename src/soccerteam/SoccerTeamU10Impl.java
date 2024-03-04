package soccerteam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * This class represents a U10 Soccer Team. It has: (1) a candidate pool which includes all Players
 * added by the coach; (2) a team with minimum 10 and maximum 20 Players will be created from the
 * candidate pool based on highest skill level. Each Player in the team gets a number for their
 * jersey. The numbers must be between 1 and 20 (inclusive). Jersey numbers are unique, randomly
 * assigned, and cannot be changed once created; and (3) a Starting Lineup of 7 Players who are
 * usually the most skilled Players in the Team.
 */
public class SoccerTeamU10Impl implements SoccerTeam {

  private List<Player> candidatePool;
  private Map<Integer, Player> teamMembers; // Use Map for the Team: key will be the jersey number
  // since jersey number of each Player is unique and cannot be changed, value will be the Player.
  private Map<Integer, Player> startingLineup;
  private final int minPlayerNum = 10; // Minimum number of Players to create a Team.
  private final int maxPlayerNum = 20; // Maximum number of Players to create a Team.
  private final int startingLineupSize = 7;
  private final int goalieNum = 1; // Headcount of goalie in U10 Starting Lineup.
  private final int defenderNum = 2; // Headcount of defender in U10 Starting Lineup.
  private final int midfielderNum = 3; // Headcount of midfielder in U10 Starting Lineup.
  private final int forwardNum = 1; // Headcount of forward in U10 Starting Lineup.

  /**
   * Constructor of an implementation of U10 SoccerTeam, creates empty array list for candidate
   pool, and empty hash maps for Team and Starting Lineup.
   */
  public SoccerTeamU10Impl() {
    this.candidatePool = new ArrayList<>();
    this.teamMembers = new HashMap<>();
    this.startingLineup = new HashMap<>();
  }

  /**
   * Helper function to get the size of the Team (not the candidate pool), used for assigning
   jersey numbers.
   * @return the size of the Team, which must be an integer between minPlayerNum and maxPlayerNum
   */
  private int getTeamSize() {
    return this.teamMembers.size();
  }

  @Override
  public void addPlayer(Player p) throws IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("Player to be added cannot be null");
    }
    // U10 Team only accepts U10 Players.
    if (!(p instanceof PlayerU10Impl)) {
      throw new IllegalArgumentException("Can only add U10 Player.");
    }
    if (this.candidatePool.contains(p)) {
      throw new IllegalArgumentException("This Player is already added.");
    }
    this.candidatePool.add(p);
  }

  @Override
  public void removePlayer(Player p) throws IllegalArgumentException, IllegalStateException {
    if (!this.candidatePool.contains(p)) {
      throw new IllegalArgumentException("This Player does not exist.");
    }
    this.candidatePool.remove(p);
    if (this.teamMembers.containsValue(p)) {
      this.teamMembers.entrySet().removeIf(entry -> (p.equals(entry.getValue())));
      if (this.getTeamSize() < minPlayerNum) {
        throw new IllegalStateException("Not enough Players for the team.");
      }
      if (this.startingLineup.containsValue(p)) {
        this.startingLineup.entrySet().removeIf(entry -> (p.equals(entry.getValue())));
        throw new IllegalStateException("Not enough Players for the starting lineup.");
      }
    }
  }

  @Override
  public void createTeam() throws IllegalStateException {
    int size = this.candidatePool.size();
    if (size < minPlayerNum) {
      throw new IllegalStateException("Less than " + minPlayerNum + " Players, cannot form a team. "
          + "You only have " + size + " Players now, please add more.");
    } else if (size > maxPlayerNum) {
      size = maxPlayerNum;
    }
    this.candidatePool.sort(new SortBySkillLevel());
    //Assign jersey numbers.
    List<Integer> jerseyNumbers = new ArrayList<>();
    int i;
    for (i = 1; i <= maxPlayerNum; i++) {
      jerseyNumbers.add(i);
    }
    Collections.shuffle(jerseyNumbers);
    this.teamMembers.clear();
    for (i = 0; i < size; i++) {
      this.teamMembers.put(jerseyNumbers.get(i), candidatePool.get(i));
    }
  }

  /**
   * Helper function to choose and set the Starting Lineup by first sorting all Team Players based
   on skill level and get the top seven Players, then assign Positions. This helper function will
   be called once the coach calls the getStartingLineup() method.
   */
  private void setStartingLineup() {
    this.startingLineup.clear();
    // Pick the top 7 skill level Players from the Team and put all 7 entries into a list
    List<Entry<Integer, Player>> slPool = this.teamMembers.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(new SortBySkillLevel())).collect(Collectors.toList())
        .subList(0, startingLineupSize);

    // Put the 7 entries into the startingLineup Hash Map.
    // Create a list of shallow copy of the 7 Starting Lineup Players
    List<Player> copy = new ArrayList<>();
    for (Entry<Integer, Player> entry : slPool) {
      this.startingLineup.put(entry.getKey(), entry.getValue());
      copy.add(entry.getValue());
    }

    // Assign Position by first considering their preferred Positions, as long as that Position's
    // headcount still has vacancy, satisfy the Player's preference.
    int goalieCount = goalieNum;
    int defenderCount = defenderNum;
    int midfielderCount = midfielderNum;
    int forwardCount = forwardNum;
    List<Player> toRemove = new ArrayList<>();
    for (Player p : copy) {
      if (p.getPreferredPosition() == Position.GOALIE && goalieCount > 0) {
        p.setPosition(Position.GOALIE);
        toRemove.add(p);
        goalieCount -= 1;
      } else if (p.getPreferredPosition() == Position.DEFENDER && defenderCount > 0) {
        p.setPosition(Position.DEFENDER);
        toRemove.add(p);
        defenderCount -= 1;
      } else if (p.getPreferredPosition() == Position.MIDFIELDER && midfielderCount > 0) {
        p.setPosition(Position.MIDFIELDER);
        toRemove.add(p);
        midfielderCount -= 1;
      } else if (p.getPreferredPosition() == Position.FORWARD && forwardCount > 0) {
        p.setPosition(Position.FORWARD);
        toRemove.add(p);
        forwardCount -= 1;
      }
    }
    copy.removeAll(toRemove); // Remove all Players that have been assigned Position according to
    // their preference.
    // For the remaining Players, randomly assign Positions until all the headcounts are used up.
    while (goalieCount > 0 || defenderCount > 0 || midfielderCount > 0 || forwardCount > 0) {
      for (Player p : copy) {
        if (goalieCount > 0) {
          p.setPosition(Position.GOALIE);
          goalieCount -= 1;
        } else if (defenderCount > 0) {
          p.setPosition(Position.DEFENDER);
          defenderCount -= 1;
        } else if (midfielderCount > 0) {
          p.setPosition(Position.MIDFIELDER);
          midfielderCount -= 1;
        } else {
          p.setPosition(Position.FORWARD);
          forwardCount -= 1;
        }
      }
    }
  }

  @Override
  public String getAllTeamPlayers() throws IllegalStateException {
    if (this.teamMembers.isEmpty()) {
      throw new IllegalStateException("Team has not been created.");
    }
    List<String> output = new ArrayList<>();
    List<Entry<Integer, Player>> sortedList = this.teamMembers.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(new SortByLastName())).collect(Collectors.toList());
    for (Entry<Integer, Player> entry : sortedList) {
      output.add(String.format("%s, %s, %d", entry.getValue().getLastName(),
          entry.getValue().getFirstName(), entry.getKey()));
    }
    return String.join("\n", output);
  }

  @Override
  public String getStartingLineup() throws IllegalStateException {
    if (this.teamMembers.isEmpty()) {
      throw new IllegalStateException("Team has not been created.");
    }
    this.setStartingLineup();
    List<String> output = new ArrayList<>();
    List<Entry<Integer, Player>> sorteList = this.startingLineup.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(new SortByPosition())).collect(Collectors.toList());
    for (Entry<Integer, Player> entry : sorteList) {
      output.add(String.format("%s, %s, %s, %d", entry.getValue().getAssignedPosition().toString(),
          entry.getValue().getLastName(), entry.getValue().getFirstName(), entry.getKey()));
    }
    return String.join("\n", output);
  }
}
