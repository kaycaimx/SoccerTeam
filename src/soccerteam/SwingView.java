package soccerteam;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Java Swing GUI implementation of the SoccerTeamView interface.
 */
public class SwingView extends JFrame implements SoccerTeamView {
  private final String caption;
  private final JPanel panel;
  private final JPanel playerPanel;
  private final JPanel teamPanel;
  private final JLabel firstNameLabel;
  private final JTextField firstName;
  private final JLabel lastNameLabel;
  private final JTextField lastName;
  private final JLabel birthDate;
  private final JComboBox<Integer> yearCombo;
  private final int startingYear = 2013; // The starting year of the dropdown menu for the birth
  // year JComboBox, since this is a U10 implementation, starting year is 2023 - 10 = 2013.
  private final JComboBox<Month> monthCombo;
  private final JComboBox<Integer> dayCombo;
  private final JLabel preferredPosition;
  private final JComboBox<Position> positionCombo;
  private final JLabel skillLevel;
  private final JComboBox<Integer> skillCombo;
  private final JButton addPlayer;
  private final JButton createTeam;
  private final JButton getAllTeam;
  private final JButton getStartingLineup;
  private final JLabel team;

  /**
   * Initializes the window which consists of a playerPanel for creating and adding Players, and
   a teamPanel for displaying all Team Players/starting lineup, both packed in the panel.
   * @param caption the caption of the window
   */
  public SwingView(String caption) {
    super(caption);
    this.caption = caption;

    setSize(800, 600);
    setLocation(100, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // set main panel
    panel = new JPanel();
    FlowLayout flowLayout = new FlowLayout();
    panel.setLayout(flowLayout);
    panel.setSize(800, 600);

    // set playerPanel for creating and adding Players
    playerPanel = new JPanel();
    playerPanel.setSize(400, 600);
    GridBagLayout gridBagLayoutPlayerPanel = new GridBagLayout();
    playerPanel.setLayout(gridBagLayoutPlayerPanel);

    firstNameLabel = new JLabel("First name: ", SwingConstants.RIGHT);
    addComponent(playerPanel, firstNameLabel, 0, 0, 1, 1);

    firstName = new JTextField(20);
    addComponent(playerPanel, firstName, 1, 0, 2, 1);

    lastNameLabel = new JLabel("Last name: ", SwingConstants.RIGHT);
    addComponent(playerPanel, lastNameLabel, 0, 1, 1, 1);

    lastName = new JTextField(20);
    addComponent(playerPanel, lastName, 1, 1, 2, 1);

    birthDate = new JLabel("Select the birth date:", SwingConstants.CENTER);
    addComponent(playerPanel, birthDate, 0, 2, 3, 1);

    int currentYear = LocalDate.now().getYear();
    Integer[] years = new Integer[currentYear - startingYear + 1];
    for (int i = 0; i < currentYear - startingYear + 1; i++) {
      years[i] = i + startingYear;
    }
    yearCombo = new JComboBox<>(years);
    yearCombo.setSelectedIndex(0);
    addComponent(playerPanel, yearCombo, 0, 3, 1, 1);

    Month[] months = {Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY,
        Month.JUNE, Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER,
        Month.DECEMBER};
    monthCombo = new JComboBox<>(months);
    monthCombo.setSelectedIndex(0);
    addComponent(playerPanel, monthCombo, 1, 3, 1, 1);

    Integer[] days = new Integer[31];
    for (int i = 1; i < 32; i++) {
      days[i - 1] = i;
    }
    dayCombo = new JComboBox<>(days);
    dayCombo.setSelectedIndex(0);
    addComponent(playerPanel, dayCombo, 2, 3, 1, 1);

    preferredPosition = new JLabel("Preferred position: ", SwingConstants.RIGHT);
    addComponent(playerPanel, preferredPosition, 0, 4, 1, 1);

    Position[] positions = {Position.GOALIE, Position.DEFENDER, Position.MIDFIELDER,
        Position.FORWARD};
    positionCombo = new JComboBox<>(positions);
    positionCombo.setSelectedIndex(0);
    addComponent(playerPanel, positionCombo, 1, 4, 1, 1);

    skillLevel = new JLabel("Skill level: ", SwingConstants.RIGHT);
    addComponent(playerPanel, skillLevel, 0, 5, 1, 1);

    Integer[] skills = {1, 2, 3, 4, 5};
    skillCombo = new JComboBox<>(skills);
    skillCombo.setSelectedIndex(0);
    addComponent(playerPanel, skillCombo, 1, 5, 1, 1);

    Icon playerIcon = new ImageIcon(getClass().getResource("/icons/footballer.png"));
    addPlayer = new JButton("Create Player & Add", playerIcon);
    addComponent(playerPanel, addPlayer, 1, 6, 2, 1);

    Icon teamIcon = new ImageIcon(getClass().getResource("/icons/soccer-ball.png"));
    createTeam = new JButton("Create Team!", teamIcon);
    addComponent(playerPanel, createTeam, 1, 7, 2, 1);

    // set teamPanel for displaying all Team Players/starting lineup
    teamPanel = new JPanel();
    teamPanel.setSize(400, 600);
    GridBagLayout gridBagLayoutTeamPanel = new GridBagLayout();
    teamPanel.setLayout(gridBagLayoutTeamPanel);

    getAllTeam = new JButton("Get All Team");
    addComponent(teamPanel, getAllTeam, 0, 0, 1, 1);

    JLabel empty = new JLabel();
    addComponent(teamPanel, empty, 1, 0, 1, 1);
    empty.setPreferredSize(new Dimension(100, 50));

    getStartingLineup = new JButton("Get Starting Lineup");
    addComponent(teamPanel, getStartingLineup, 2, 0, 1, 1);

    Icon fieldBackground = new ImageIcon(getClass().getResource("/icons/soccer-field.png"));
    team = new JLabel("", fieldBackground, SwingConstants.CENTER);

    team.setPreferredSize(new Dimension(300, 500));
    team.setFont(new Font("Arial", Font.BOLD, 16));
    team.setHorizontalTextPosition(JLabel.CENTER);
    team.setVerticalTextPosition(JLabel.CENTER);
    addComponent(teamPanel, team, 0, 1, 3, 7);

    this.panel.add(playerPanel);
    this.panel.add(teamPanel);

    this.add(panel);

    this.pack();
    this.setVisible(true);
  }

  /**
   * Helper function to add a JComponent to a panel with GridBagLayout.
   * @param panel the JPanel where the component will be added
   * @param component the JComponent to be added
   * @param gridx the column of the component
   * @param gridy the row of the component
   * @param width the number of columns a component span
   * @param height the number of rows a component span
   */
  private void addComponent(JPanel panel, JComponent component, int gridx, int gridy, int width,
      int height) {
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = gridx;
    c.gridy = gridy;
    c.gridwidth = width;
    c.gridheight = height;
    c.insets = new Insets(10, 5, 10, 5);
    c.fill = GridBagConstraints.HORIZONTAL;
    panel.add(component, c);
  }

  @Override
  public void addFeatures(Features f) throws IllegalArgumentException {
    if (f == null) {
      throw new IllegalArgumentException("Controller cannot be null.");
    }
    addPlayer.addActionListener(e -> f.createPlayer(firstName.getText(), lastName.getText(),
        (int) yearCombo.getSelectedItem(), (Month) monthCombo.getSelectedItem(),
        (int) dayCombo.getSelectedItem(), (Position) positionCombo.getSelectedItem(),
        (int) skillCombo.getSelectedItem()));
    createTeam.addActionListener(e -> f.createTeam());
    getAllTeam.addActionListener(e -> f.showAllTeam());
    getStartingLineup.addActionListener(e -> f.showStartingLineup());
  }

  @Override
  public void displayTeam(String msg) throws IllegalArgumentException {
    if (msg == null) {
      throw new IllegalArgumentException("List of Players cannot be null.");
    }
    team.setText(msg);
  }

  @Override
  public void clearNamesInput() {
    firstName.setText("");
    lastName.setText("");
  }

  @Override
  public void showErrorMsg(String errMsg) throws IllegalArgumentException {
    if (errMsg == null) {
      throw new IllegalArgumentException("Error message cannot be null.");
    }
    JOptionPane.showMessageDialog(this.panel, errMsg, caption, JOptionPane.ERROR_MESSAGE);
  }
}
