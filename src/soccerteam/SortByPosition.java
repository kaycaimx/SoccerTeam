package soccerteam;

import java.util.Comparator;

/**
 * This is a Comparator to sort Players by their Positions (goalie, defender, midfielder, forward),
 based on their ordinals in the Position enum. Players with the same position should be ordered
 alphabetically by their name.
 */
public class SortByPosition implements Comparator<Player> {

  /**
   * To compare two Player objects.
   * @param a the first object to be compared.
   * @param b the second object to be compared.
   * @return integer result.
   */
  public int compare(Player a, Player b) {
    int positionCompare = a.getAssignedPosition().compareTo(b.getAssignedPosition());
    int nameCompare;
    if (a.getLastName().compareTo(b.getLastName()) != 0) {
      nameCompare = a.getLastName().compareTo(b.getLastName());
    } else {
      nameCompare = a.getFirstName().compareTo(b.getFirstName());
    }
    return (positionCompare == 0) ? nameCompare : positionCompare;
  }
}
