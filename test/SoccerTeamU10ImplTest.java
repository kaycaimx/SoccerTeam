import static org.junit.Assert.assertEquals;

import java.time.Month;
import org.junit.Before;
import org.junit.Test;
import soccerteam.DummyPlayer;
import soccerteam.Player;
import soccerteam.PlayerU10Impl;
import soccerteam.Position;
import soccerteam.SoccerTeam;
import soccerteam.SoccerTeamU10Impl;

/**
 * A JUnit test class for the SoccerTeamU10Impl class.
 */
public class SoccerTeamU10ImplTest {
  private SoccerTeam testTeam = new SoccerTeamU10Impl();
  private Player p1 = new PlayerU10Impl("Ronaldo I", "Nazário", 2013, Month.SEPTEMBER, 18,
      Position.FORWARD, 5);
  private Player p2 = new PlayerU10Impl("Ronaldo II", "Nazário", 2013, Month.SEPTEMBER, 18,
      Position.FORWARD, 4);
  private Player p3 = new PlayerU10Impl("Ronaldo III", "Nazário", 2013, Month.SEPTEMBER, 18,
      Position.FORWARD, 3);
  private Player p4 = new PlayerU10Impl("Ronaldo IV", "Nazário", 2013, Month.SEPTEMBER, 18,
      Position.FORWARD, 2);
  private Player p5 = new PlayerU10Impl("Tsubasa I", "Ozora", 2014, Month.JULY, 28,
      Position.GOALIE, 5);
  private Player p6 = new PlayerU10Impl("Tsubasa II", "Ozora", 2014, Month.JULY, 28,
      Position.GOALIE, 4);
  private Player p7 = new PlayerU10Impl("Tsubasa III", "Ozora", 2014, Month.JULY, 28,
      Position.GOALIE, 3);
  private Player p8 = new PlayerU10Impl("Tsubasa IV", "Ozora", 2014, Month.JULY, 28,
      Position.GOALIE, 2);
  private Player p9 = new PlayerU10Impl("Elsa I", "Murphy", 2014, Month.JULY, 21,
      Position.MIDFIELDER, 5);
  private Player p10 = new PlayerU10Impl("Elsa II", "Murphy", 2014, Month.JULY, 21,
      Position.MIDFIELDER, 4);
  private Player p11 = new PlayerU10Impl("Elsa III", "Murphy", 2014, Month.JULY, 21,
      Position.MIDFIELDER, 3);
  private Player p12 = new PlayerU10Impl("Elsa IV", "Murphy", 2014, Month.JULY, 21,
      Position.MIDFIELDER, 2);
  private Player p13 = new PlayerU10Impl("Anna I", "Morris", 2015, Month.JANUARY, 1,
      Position.MIDFIELDER, 5);
  private Player p14 = new PlayerU10Impl("Anna II", "Morris", 2015, Month.JANUARY, 1,
      Position.MIDFIELDER, 4);
  private Player p15 = new PlayerU10Impl("Anna III", "Morris", 2015, Month.JANUARY, 1,
      Position.MIDFIELDER, 3);
  private Player p16 = new PlayerU10Impl("Anna IV", "Morris", 2015, Month.JANUARY, 1,
      Position.MIDFIELDER, 2);
  private Player p17 = new PlayerU10Impl("Adam I", "Morales", 2015, Month.JUNE, 4,
      Position.DEFENDER, 5);
  private Player p18 = new PlayerU10Impl("Adam II", "Morales", 2015, Month.JUNE, 4,
      Position.DEFENDER, 4);
  private Player p19 = new PlayerU10Impl("Adam III", "Morales", 2015, Month.JUNE, 4,
      Position.DEFENDER, 3);
  private Player p20 = new PlayerU10Impl("Adam IV", "Morales", 2015, Month.JUNE, 4,
      Position.DEFENDER, 2);
  private Player p21 = new PlayerU10Impl("Kay", "Cai", 2013, Month.DECEMBER, 31,
      Position.MIDFIELDER, 1);

  /**
   * Set up the test team. Add 9 Players first.
   */
  @Before
  public void setUp() {
    testTeam.addPlayer(p1);
    testTeam.addPlayer(p2);
    testTeam.addPlayer(p3);
    testTeam.addPlayer(p4);
    testTeam.addPlayer(p5);
    testTeam.addPlayer(p6);
    testTeam.addPlayer(p7);
    testTeam.addPlayer(p8);
    testTeam.addPlayer(p9);
  }

  /**
   * To test that exception will be thrown if a null Player is added.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNullPlayer() {
    testTeam.addPlayer(null);
  }

  /**
   * To test that exception will be thrown if a non-U10 Player is added.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNonU10Player() {
    Player dummy = new DummyPlayer();
    testTeam.addPlayer(dummy);
  }

  /**
   * To test that exception will be thrown if the same Player is added twice.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddSamePlayerAgain() {
    testTeam.addPlayer(p1);
  }

  /**
   * To test that exception will be thrown if removing a non-existing Player from the team.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNonExistingPlayer() {
    testTeam.addPlayer(p10);
    testTeam.createTeam();
    Player nonExisting = new PlayerU10Impl("John", "Doe", 2023, Month.APRIL, 5,
        Position.FORWARD, 5);
    testTeam.removePlayer(nonExisting);
  }

  /**
   * To test that exception will be thrown if a removing a Player will cause the Team less than
   10 Players.
   */
  @Test (expected = IllegalStateException.class)
  public void testRemovePlayerCauseTeamLessThan10() {
    testTeam.addPlayer(p10);
    testTeam.createTeam();
    testTeam.removePlayer(p10);
  }

  /**
   * To test the removePlayer method works correctly.
   */
  @Test
  public void testRemovePlayer() {
    testTeam.addPlayer(p13);
    testTeam.addPlayer(p17);
    testTeam.createTeam();
    String[] lines = testTeam.getAllTeamPlayers().split("\n");
    assertEquals("Morales, Adam", lines[0].substring(0, 13));
    testTeam.removePlayer(p17);
    lines = testTeam.getAllTeamPlayers().split("\n");
    assertEquals("Morris, Anna", lines[0].substring(0, 12));
  }

  /**
   * To test that exception will be thrown if a removing a Player will cause the Starting Lineup
   less than 7 Players, meanwhile the Team still has more than 10 Players.
   */
  @Test (expected = IllegalStateException.class)
  public void testRemovePlayerCauseStartingLineupLessThan7() {
    testTeam.addPlayer(p10);
    testTeam.addPlayer(p11);
    testTeam.addPlayer(p12);
    testTeam.createTeam();
    testTeam.getStartingLineup();
    testTeam.removePlayer(p1);
  }

  /**
   * To test that exception will be thrown if trying to create a Team with less than 10 Players.
   */
  @Test(expected = IllegalStateException.class)
  public void testCreateTeamWithLessThan10Players() {
    testTeam.createTeam();
  }

  /**
   * To test that when create a Team with more than 20 candidate Players, the Player with the
   lowest skill level will be ignored.
   */
  @Test
  public void testCreateTeamOver20DropLowestSkillLevel() {
    testTeam.addPlayer(p10);
    testTeam.addPlayer(p11);
    testTeam.addPlayer(p12);
    testTeam.addPlayer(p13);
    testTeam.addPlayer(p14);
    testTeam.addPlayer(p15);
    testTeam.addPlayer(p16);
    testTeam.addPlayer(p17);
    testTeam.addPlayer(p18);
    testTeam.addPlayer(p19);
    testTeam.addPlayer(p21); // Add the 20th Player with the lowest skill level of 1
    testTeam.createTeam();   // Create team
    String[] lines = testTeam.getAllTeamPlayers().split("\n");
    assertEquals("Cai, Kay", lines[0].substring(0, 8)); // Ensure this 20th Player
    // is picked and is the first of the Team list because of last name starting with "C"

    testTeam.addPlayer(p20); // Add the 21st Player with a higher skill level (2)
    testTeam.createTeam();   // Create team again
    lines = testTeam.getAllTeamPlayers().split("\n");
    assertEquals("Morales, Adam", lines[0].substring(0, 13)); // Check that Player Cai, Kay
    // is dropped from the Team list
  }

  /**
   * To test the createTeam method and that getAllTeamPlayer returns the correct string (sorting
   alphabetically by last name).
   */
  @Test
  public void testCreateTeamBasic() {
    testTeam.addPlayer(p10);
    testTeam.addPlayer(p13);
    testTeam.addPlayer(p17);
    testTeam.createTeam();
    String[] lines = testTeam.getAllTeamPlayers().split("\n");
    assertEquals("Morales, Adam", lines[0].substring(0, 13));
    assertEquals("Morris, Anna", lines[1].substring(0, 12));
    assertEquals("Murphy, Elsa", lines[2].substring(0, 12));
  }

  /**
   * To test the getStartingLineup method.
   */
  @Test
  public void testGetStartingLineup() {
    testTeam.addPlayer(p13);
    testTeam.addPlayer(p17);
    testTeam.createTeam();
    String[] lines = testTeam.getStartingLineup().split("\n");
    assertEquals("Goalie", lines[0].substring(0, 6));
    assertEquals("Defender, Morales", lines[1].substring(0, 17));
    assertEquals("Defender", lines[2].substring(0, 8));
    assertEquals("Midfielder, Morris", lines[3].substring(0, 18));
    assertEquals("Midfielder", lines[4].substring(0, 10));
    assertEquals("Midfielder", lines[5].substring(0, 10));
    assertEquals("Forward", lines[6].substring(0, 7));
  }

  /**
   * To test that exception will be thrown if the user try getting all Players while having not
   called the createTeam() method.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetAllPlayersWhileTeamNotCreated() {
    testTeam.addPlayer(p10);
    testTeam.addPlayer(p13);
    testTeam.addPlayer(p17);
    testTeam.getAllTeamPlayers();
  }

  /**
   * To test that exception will be thrown if the user try getting the starting lineup while having
   not called the createTeam() method.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetStartingLineupWhileTeamNotCreated() {
    testTeam.addPlayer(p10);
    testTeam.addPlayer(p13);
    testTeam.addPlayer(p17);
    testTeam.getStartingLineup();
  }
}
