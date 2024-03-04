package soccerteam;

import java.util.Comparator;

/**
 * This is a Comparator to sort Players alphabetically by their last name. If the last names
 are the same, then compare by the first names.
 */
public class SortByLastName implements Comparator<Player> {

  /**
   * To compare two Player objects by Names. If the last names are the same, then compare by
   the first names.
   * @param a the first object to be compared.
   * @param b the second object to be compared.
   * @return integer result.
   */
  public int compare(Player a, Player b) {
    int lastNameCompare = a.getLastName().compareTo(b.getLastName());
    int firstNameCompare = a.getFirstName().compareTo(b.getFirstName());
    return (lastNameCompare == 0) ? firstNameCompare : lastNameCompare;
  }
}
