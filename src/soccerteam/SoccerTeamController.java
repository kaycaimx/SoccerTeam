package soccerteam;

/**
 * Represents a Controller for SoccerTeam: it gets inputs from the user and pass them to model to
 create and add Players, gets commands from user to create Team and display all Team Players and
 the starting lineup to the user in some form.
 */
public interface SoccerTeamController {

  /**
   * This method connects the model with the applicable view and give control to the controller.
   */
  public void go();
}
