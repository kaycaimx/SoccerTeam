import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.PlayerU10Impl;
import soccerteam.Position;

/**
 * A JUnit test class for the PlayerU10Impl class.
 */
public class PlayerU10ImplTest {
  private Player p1;

  /**
   * Initializing JUnit test class for a PlayerU10Impl.
   */
  @Before
  public void setUp() {
    this.p1 = new PlayerU10Impl("Ronaldo", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 5);
  }

  /**
   * To test that exception will be thrown if the first name is not provided.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBlankFirstName() {
    this.p1 = new PlayerU10Impl("", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 5);
  }

  /**
   * To test that exception will be thrown if the last name is blank.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBlankLastName() {
    this.p1 = new PlayerU10Impl("Ronaldo", "  ", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 5);
  }

  /**
   * To test that exception will be thrown if any parameter is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullParameter() {
    this.p1 = new PlayerU10Impl("Ronaldo", "Nazário", 2013, Month.SEPTEMBER, 18,
        null, 5);
  }

  /**
   * To test that exception will be thrown if the format of birthdate string argument is wrong.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBirthDate() {
    Player p2 = new PlayerU10Impl("Ronaldo", "Nazário", 2013, Month.SEPTEMBER, 31,
        Position.FORWARD, 5);
  }

  /**
   * To test that exception will be thrown if the age of the player is older than 10.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAgeOlderThan10() {
    Player p2 = new PlayerU10Impl("Ronaldo", "Nazário", 2013, Month.APRIL, 1,
        Position.FORWARD, 5);
  }

  /**
   * To test that exception will be thrown if the skill level provided is greater than 5.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongSkillLevelGreater() {
    Player p2 = new PlayerU10Impl("Ronaldo", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 6);
  }

  /**
   * To test that exception will be thrown if the skill level provided is smaller than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongSkillLevelSmaller() {
    Player p2 = new PlayerU10Impl("Ronaldo", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 0);
  }

  /**
   * To test getFirstName method.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("Ronaldo", this.p1.getFirstName());
  }

  /**
   * To test getLastName method.
   */
  @Test
  public void testGetLastName() {
    assertEquals("Nazário", this.p1.getLastName());
  }

  /**
   * To test getDateOfBirth method.
   */
  @Test
  public void testGetDateOfBirth() {
    LocalDate expected = LocalDate.of(2013, 9, 18);
    assertTrue(expected.isEqual(this.p1.getDateOfBirth()));
  }

  /**
   * To test setPosition and getAssignedPosition method.
   */
  @Test
  public void testSetPositionAndGetAssignedPosition() {
    this.p1.setPosition(Position.GOALIE);
    assertEquals("Goalie", this.p1.getAssignedPosition().toString());
  }

  /**
   * To test that exception will be thrown if trying to get the assigned position of a Player
   when they are not assigned to any position yet.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidGetAssignedPosition() {
    this.p1.getAssignedPosition();
  }

  /**
   * To test getPreferredPosition method.
   */
  @Test
  public void testGetPreferredPosition() {
    assertTrue(this.p1.getPreferredPosition() == Position.FORWARD);
  }

  /**
   * To test that exception will be thrown if trying to set skill level to be greater than 5.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSetSkillLevel() {
    this.p1.setSkillLevel(6);
  }

  /**
   * To test setSkillLevel and getSkillLevel methods.
   */
  @Test
  public void testSetSkillLevelAndGetSkillLevel() {
    assertEquals(5, this.p1.getSkillLevel());
    this.p1.setSkillLevel(4);
    assertEquals(4, this.p1.getSkillLevel());
  }

  /**
   * To test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Ronaldo Nazário", this.p1.toString());
  }
}
