import org.junit.Test;
import soccerteam.SoccerTeam;
import soccerteam.SoccerTeamController;
import soccerteam.SoccerTeamU10Impl;
import soccerteam.SoccerTeamView;
import soccerteam.SwingController;
import soccerteam.SwingView;

/**
 * Test case for the Swing controller.
 */
public class SwingControllerTest {

  /**
   * To test that an Illegal Argument Exception will be thrown if the model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    SoccerTeamView view = new SwingView("Test");
    SoccerTeamController c = new SwingController(null, view);
  }

  /**
   * To test that an Illegal Argument Exception will be thrown if the view is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    SoccerTeam model = new SoccerTeamU10Impl();
    SoccerTeamController c = new SwingController(model, null);
  }
}
