package soccerteam;

import java.util.Comparator;

/**
 * This is a Comparator to sort Players by their skill levels (1-5). A Player with a higher skill
 level should rank before the other Player with lower skill level.
 */
public class SortBySkillLevel implements Comparator<Player> {

  public int compare(Player a, Player b) {
    return b.getSkillLevel() - a.getSkillLevel();
  }
}
