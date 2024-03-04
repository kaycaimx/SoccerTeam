package soccerteam;

import java.time.Month;

/**
 * Interface for features of a SoccerTeamController for Java Swing view. The controller should
 implement this interface to inherit the features and get connected with the view.
 */
public interface Features {

  /**
   * Gets inputs from the user via view, pass to model to create a Player and add such Player to
   the candidate pool of Team.
   * @param firstName the first name of the Player
   * @param lastName the last name of the Player
   * @param year the year of the date of birth of the Player
   * @param month the month of the date of birth of the Player, in the form of Java Enum Month
   * @param day the day of the date of birth of the Player
   * @param preferredPosition the preferred Position of the Player
   * @param skillLevel the skill level of the Player
   */
  public void createPlayer(String firstName, String lastName, int year, Month month, int day,
      Position preferredPosition, int skillLevel);

  /**
   * Asks the model to create the Team.
   */
  public void createTeam();

  /**
   * Asks the view to display all Team Players.
   */
  public void showAllTeam();

  /**
   * Asks the view to display the starting lineup.
   */
  public void showStartingLineup();
}
