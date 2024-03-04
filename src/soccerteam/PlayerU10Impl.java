package soccerteam;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * This class implements the Player interface and represents a U10 soccer player, who has
 a first name, last name, date of birth, preferred Position, assigned Position, and skill level.
 U10 Player must be under the age of 10.
 */
public class PlayerU10Impl implements Player {
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private Position preferredPosition;
  private Position assignedPosition;
  private int skillLevel;

  /**
   * Constructs a U10 soccer player with given first name, last name, date of birth, preferred
   * position and skill level.
   * @param firstName the first name of the player
   * @param lastName the last name of the player
   * @param year the year of the date of birth of the player
   * @param month the month of the date of birth of the player, in the form of Java Enum Month
   * @param day the day of the date of birth of the player
   * @param preferredPosition the preferred Position of the player
   * @param skillLevel the skill level of the Player
   * @throws IllegalArgumentException if any of the arguments given fails to meet requirements,
   such as skill level out of bound, age is older than 10, null object, etc.
   */
  public PlayerU10Impl(String firstName, String lastName, int year, Month month, int day,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException {
    if (firstName == null || lastName == null || month == null || preferredPosition == null) {
      throw new IllegalArgumentException("Player parameter cannot be null.");
    }
    if ("".equals(firstName.strip()) || "".equals(lastName.strip())) {
      throw new IllegalArgumentException("Name cannot be blank.");
    }
    try {
      LocalDate bd = LocalDate.of(year, month, day);
      this.dateOfBirth = bd;
    } catch (DateTimeException e) {
      throw new IllegalArgumentException("Not a valid date.");
    }
    if (!this.checkAgeUnder10()) {
      throw new IllegalArgumentException("The player is 10 years of age or older.");
    }

    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level must be an integer between 1 and 5.");
    }
    this.skillLevel = skillLevel;

    this.firstName = firstName;
    this.lastName = lastName;
    this.preferredPosition = preferredPosition;
    this.assignedPosition = null;
  }

  @Override
  public String getFirstName() {
    return this.firstName;
  }

  @Override
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  @Override
  public void setPosition(Position p) throws IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("Position to be set cannot be null.");
    }
    this.assignedPosition = p;
  }

  @Override
  public Position getAssignedPosition() throws IllegalStateException {
    if (this.assignedPosition == null) {
      throw new IllegalStateException("This player has not been assigned a Position.");
    }
    return this.assignedPosition;
  }

  @Override
  public Position getPreferredPosition() {
    return this.preferredPosition;
  }

  @Override
  public void setSkillLevel(int skillLevel) throws IllegalArgumentException {
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level must be an integer between 1 and 5.");
    }
    this.skillLevel = skillLevel;
  }

  @Override
  public int getSkillLevel() {
    return this.skillLevel;
  }

  /**
   * A helper function to check if the player is under age 10 as of now.
   * @return true if the player is under 10
   */
  private boolean checkAgeUnder10() {
    LocalDate now = LocalDate.now();
    return Period.between(this.dateOfBirth, now).getYears() < 10;
  }

  @Override
  public String toString() {
    return String.format("%s %s", getFirstName(), getLastName());
  }
}
