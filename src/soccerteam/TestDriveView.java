package soccerteam;

/**
 * Test driver for a Java Swing Controller and View.
 */
public class TestDriveView {

  /**
   * Run a SoccerTeam with Java Swing Controller and View.
   * @param args code
   */
  public static void main(String[] args) {
    SoccerTeamView view = new SwingView("U10 Soccer Team");
    SoccerTeam model = new SoccerTeamU10Impl();
    SoccerTeamController c = new SwingController(model, view);
    c.go();
  }
}
