package soccerteam;

import java.time.LocalDate;

/**
 * Interface for a soccer player.
 */
public interface Player {

  /**
   * Get the first name of the player.
   * @return the first name of the player
   */
  String getFirstName();

  /**
   * Get the last name of the player.
   * @return the last name of the player
   */
  String getLastName();

  /**
   * Get the date of birth of the player.
   * @return the date of birth of the player
   */
  LocalDate getDateOfBirth();

  /**
   * Assign a Position to the current player.
   * @param p a Position to be assigned to the current player
   * @throws IllegalArgumentException if the Position given is null
   */
  void setPosition(Position p) throws IllegalArgumentException;

  /**
   * Get the assigned Position of the player.
   * @return the assigned Position of the player
   * @throws IllegalStateException if the player has not been assigned any Position
   */
  Position getAssignedPosition() throws IllegalStateException;

  /**
   * Get the preferred Position of the player.
   * @return the preferred Position of the player
   */
  Position getPreferredPosition();

  /**
   * Set the skill level of the player.
   * @param skillLevel an integer between 1-5 which represents the skill level
   * @throws IllegalArgumentException if skill level is out of bound
   */
  void setSkillLevel(int skillLevel) throws IllegalArgumentException;

  /**
   * Get the skill level of the player.
   * @return the skill level of the player
   */
  int getSkillLevel();
}
