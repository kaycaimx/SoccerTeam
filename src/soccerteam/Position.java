package soccerteam;

/**
 * This enum represents the position of a soccer Player on the field.
 */
public enum Position { GOALIE {
    @Override public String toString() {
      return "Goalie";
    }
  }, DEFENDER {
    @Override public String toString() {
      return "Defender";
    }
  }, MIDFIELDER {
    @Override public String toString() {
      return "Midfielder";
    }
  }, FORWARD {
    @Override public String toString() {
      return "Forward";
    }
  }
}
