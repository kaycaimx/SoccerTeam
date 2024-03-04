package soccerteam;

/**
 * Interface for a soccer team. SoccerTeam is a composites of Players.
 */
public interface SoccerTeam {

  /**
   * Add a Player to a soccer team's candidate pool.
   * @param p a Player object to be added as a team candidate
   * @throws IllegalArgumentException if this Player already exists or if this Player fails to
   satisfy given requirements
   */
  void addPlayer(Player p) throws IllegalArgumentException;

  /**
   * Remove a Player object from a soccer team.
   * @param p a Player object to be removed
   * @throws IllegalArgumentException if this Player does not exist in the team
   * @throws IllegalStateException if removing this Player will make the team or the starting
   lineup have not enough Players to form a Team (at least 10 Players) or a Starting Lineup
  (at least 7 Players for U10)
   */
  void removePlayer(Player p) throws IllegalArgumentException, IllegalStateException;

  /**
   * Creates a team of a minimum of 10 Players and a maximum of 20 Players from a candidate pool
   based on skill level. If the pool has more than 20 Players, the ones with the lowest skill level
   will be ignored.
   * @throws IllegalStateException if the candidate pool has less than 10 Players
   */
  void createTeam() throws IllegalStateException;

  /**
   * Get a string with a list of all the Players in the team. The following information must be
   provided for every player: first name, last name, jersey number. The list must be sorted
   in alphabetical order (last name).
   * @return the string with the aforementioned list.
   * @throws IllegalStateException if the team has not been created.
   */
  String getAllTeamPlayers() throws IllegalStateException;

  /**
   * Get a string with a list of the starting lineup. The following information must be provided
   for every player: first name, last name, jersey number, and position. The list must be sorted
   by position (goalie, defender, midfielder, forward). Players with the same position should be
   ordered alphabetically.
   * @return the string with the aforementioned list.
   * @throws IllegalStateException if the team has not been created.
   */
  String getStartingLineup();
}
