package soccerteam;

import java.time.LocalDate;

/**
 * This class creates a dummy Player implementing the Player interface solely for testing purpose.
 */
public class DummyPlayer implements Player {

  /**
   * Constructor of a dummy Player.
   */
  public DummyPlayer() {
  }

  @Override
  public String getFirstName() {
    return "John";
  }

  @Override
  public String getLastName() {
    return "Doe";
  }

  @Override
  public LocalDate getDateOfBirth() {
    return LocalDate.of(2023, 1, 1);
  }

  @Override
  public void setPosition(Position p) {
  }

  @Override
  public Position getAssignedPosition() {
    return null;
  }

  @Override
  public Position getPreferredPosition() {
    return Position.GOALIE;
  }

  @Override
  public void setSkillLevel(int skillLevel) throws IllegalArgumentException {

  }

  @Override
  public int getSkillLevel() {
    return 1;
  }
}
