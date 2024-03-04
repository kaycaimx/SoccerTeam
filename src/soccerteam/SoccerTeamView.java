package soccerteam;

/**
 * Interface for view for a SoccerTeam.
 */
public interface SoccerTeamView {

  /**
   * Add the SoccerTeam controller to the view.
   * @param f the implementation of controller
   * @throws IllegalArgumentException if the controller given is null
   */
  public void addFeatures(Features f) throws IllegalArgumentException;

  /**
   * Displays the list of all team players or starting lineup in the view.
   * @param msg all team players or starting lineup returned by the controller from the model
   * @throws IllegalArgumentException if the msg given is null
   */
  public void displayTeam(String msg) throws IllegalArgumentException;

  /**
   * Clears the first name and last name input text fields in the view.
   */
  public void clearNamesInput();

  /**
   * Displays a popup message box to the user for errors.
   * @param errMsg the error message to be shown to th user
   * @throws IllegalArgumentException if the errMsg given is null
   */
  public void showErrorMsg(String errMsg) throws IllegalArgumentException;
}
