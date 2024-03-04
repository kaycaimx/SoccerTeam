package soccerteam;

import java.time.Month;

/**
 * Controller implementation of a SoccerTeamU10Impl for a Java Swing view.
 */
public class SwingController implements SoccerTeamController, Features {
  private final SoccerTeam model;
  private final SoccerTeamView view;

  /**
   * Constructor for a SwingController.
   * @param model a SoccerTeam implementation
   * @param view a SoccerTeamView implementation
   * @throws IllegalArgumentException if view or model is null object
   */
  public SwingController(SoccerTeam model, SoccerTeamView view) throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Cannot take any null object.");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void go() {
    view.addFeatures(this);
  }

  @Override
  public void createPlayer(String firstName, String lastName, int year, Month month, int day,
      Position preferredPosition, int skillLevel) {
    try {
      Player p = new PlayerU10Impl(firstName, lastName, year, month, day, preferredPosition,
          skillLevel); // create the new Player
      model.addPlayer(p); // talks to model to add the new Player
      view.clearNamesInput(); // tell view to clear the input text fields for next Player's info
    } catch (IllegalArgumentException e) {
      view.showErrorMsg(e.getMessage());
    }
  }

  @Override
  public void createTeam() {
    try {
      model.createTeam();
    } catch (IllegalStateException e) {
      view.showErrorMsg(e.getMessage());
    }
  }

  @Override
  public void showAllTeam() {
    try {
      view.displayTeam("<html>" + model.getAllTeamPlayers().replaceAll("\n", "<br/>")
          + "</html>"); // to accommodate showing in a JLabel
    } catch (IllegalStateException e) {
      view.showErrorMsg(e.getMessage());
    }
  }

  @Override
  public void showStartingLineup() {
    try {
      view.displayTeam("<html>" + model.getStartingLineup().replaceAll("\n", "<br/>")
          + "</html>");
    } catch (IllegalStateException e) {
      view.showErrorMsg(e.getMessage());
    }
  }
}
