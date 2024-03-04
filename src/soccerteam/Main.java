package soccerteam;

import java.time.Month;

/**
 * Main class as driver.
 */
public class Main {

  /**
   * Constructor of Main Class.
   * @param args code
   */
  public static void main(String[] args) {
    // Creating Players.
    final Player p1 = new PlayerU10Impl("Ronaldo I", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 5);
    final Player p2 = new PlayerU10Impl("Ronaldo II", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 4);
    final Player p3 = new PlayerU10Impl("Ronaldo III", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 3);
    final Player p4 = new PlayerU10Impl("Ronaldo IV", "Nazário", 2013, Month.SEPTEMBER, 18,
        Position.FORWARD, 2);
    final Player p5 = new PlayerU10Impl("Tsubasa I", "Ozora", 2014, Month.JULY, 28,
        Position.GOALIE, 5);
    final Player p6 = new PlayerU10Impl("Tsubasa II", "Ozora", 2014, Month.JULY, 28,
        Position.GOALIE, 4);
    final Player p7 = new PlayerU10Impl("Tsubasa III", "Ozora", 2014, Month.JULY, 28,
        Position.GOALIE, 3);
    final Player p8 = new PlayerU10Impl("Tsubasa IV", "Ozora", 2014, Month.JULY, 28,
        Position.GOALIE, 2);
    final Player p9 = new PlayerU10Impl("Elsa I", "Murphy", 2014, Month.JULY, 21,
        Position.MIDFIELDER, 5);
    final Player p10 = new PlayerU10Impl("Elsa II", "Murphy", 2014, Month.JULY, 21,
        Position.MIDFIELDER, 4);
    final Player p11 = new PlayerU10Impl("Elsa III", "Murphy", 2014, Month.JULY, 21,
         Position.MIDFIELDER, 3);
    final Player p12 = new PlayerU10Impl("Elsa IV", "Murphy", 2014, Month.JULY, 21,
        Position.MIDFIELDER, 2);
    final Player p13 = new PlayerU10Impl("Anna I", "Morris", 2015, Month.JANUARY, 1,
        Position.MIDFIELDER, 5);
    final Player p14 = new PlayerU10Impl("Anna II", "Morris", 2015, Month.JANUARY, 1,
        Position.MIDFIELDER, 4);
    final Player p15 = new PlayerU10Impl("Anna III", "Morris", 2015, Month.JANUARY, 1,
         Position.MIDFIELDER, 3);
    final Player p16 = new PlayerU10Impl("Anna IV", "Morris", 2015, Month.JANUARY, 1,
        Position.MIDFIELDER, 2);
    final Player p17 = new PlayerU10Impl("Adam I", "Morales", 2015, Month.JUNE, 4,
        Position.DEFENDER, 5);
    final Player p18 = new PlayerU10Impl("Adam II", "Morales", 2015, Month.JUNE, 4,
        Position.DEFENDER, 4);
    final Player p19 = new PlayerU10Impl("Adam III", "Morales", 2015, Month.JUNE, 4,
        Position.DEFENDER, 3);
    final Player p20 = new PlayerU10Impl("Adam IV", "Morales", 2015, Month.JUNE, 4,
        Position.DEFENDER, 2);
    final Player p21 = new PlayerU10Impl("Kay", "Cai", 2013, Month.DECEMBER, 31,
        Position.MIDFIELDER, 1);

    // Initializing soccer team t.
    SoccerTeam t = new SoccerTeamU10Impl();

    t.addPlayer(p1);
    t.addPlayer(p2);
    t.addPlayer(p3);
    t.addPlayer(p4);
    t.addPlayer(p5);
    t.addPlayer(p6);
    t.addPlayer(p7);
    t.addPlayer(p8);
    t.addPlayer(p9);
    //t.createTeam();
    // Calling createTeam() here will throw exception as at this stage, since only 9 Players
    // have been added.

    t.addPlayer(p21); // Add p21 here to ensure this Player gets into the pool before others but
    // will be ignored when the team is created because p21 has the lowest skill level.
    t.createTeam();
    System.out.println("----------List of All Team-------------");
    System.out.println(t.getAllTeamPlayers());
    // Call createTeam() and getAllTeamPlayers() to ensure p21 is successfully added.

    t.addPlayer(p10);
    t.addPlayer(p11);
    t.addPlayer(p12);
    t.addPlayer(p13);
    t.addPlayer(p14);
    t.addPlayer(p15);
    t.addPlayer(p16);
    t.addPlayer(p17);
    t.addPlayer(p18);
    t.addPlayer(p19);
    t.addPlayer(p20);

    t.createTeam();
    System.out.println("\n----------List of All Team-------------");
    System.out.println(t.getAllTeamPlayers());
    System.out.println("\n------List of Starting Lineup----------");
    System.out.println(t.getStartingLineup());
  }
}
