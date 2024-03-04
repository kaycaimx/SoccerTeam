### Overview:
CS5004 Spring 2023

**Final Project - Building a Children's Soccer Team**

Requirements: The British Columbia Soccer Club requests to develop a software solution to build soccer teams for children under ten years old (U10). U10 soccer teams have seven players ("Players") on the field. The best Players are usually selected as the starting lineup and the remaining Players are on the bench, ready to substitute the Players on the field.

The coaches will use the following 7v7 formation: 1 Goalie, 2 Defenders, 3 Midfielders, and 1 Forward ("Positions"). This software will be used by the head coach to enter Player information and create the U10 soccer team ("Team").

### Features:
1. The user (coach) should be able to add Players into the system as candidates for the Team;
2. The user should be notified if a Player is not allowed (because it is 10 years of age or older);
3. The user should be able to click a button to create the Team;
4. The user should be notified if there are not enough Players to create a Team;
5. The user should be able to get a list of all the Team Players; and
6. The user should be able to get a list of the starting lineup.

### How to Run:
The users can open and run the JAR file with their preferred application or from the command line. A GUI will pop out and the user can proceed as per the instructions set out in the section "How to Use the Program" below. No arguments are needed to run the jar file.

### How to Use the Program:
1. On the left side of the GUI window, the user should enter the Player's first name and last name. These names cannot be blank, otherwise, an error message will pop out.
2. Next, the user should select the Player's birth of date from the three drop-down menus. If a date is invalid (e.g., June 31, 2023) or the Player is 10 years of age or older, an error message will pop out. 
3. Next, the user should select the Player's preferred Position and skill level from the drop-down menus.
4. After all information about the Player is filled in, click the "Create Player & Add" button, this Player will be created and added to the candidates’ pool of the Team.
5. Once the user has added no less than 10 Players, the user can click the "Create Team!" button to create the Team. If the total number of Players added is less than 10, an error message will pop out with information on how many Players have already been added. If the user has added more than 20 Players, only the top 20 Players with the highest skill level will be selected to form the Team.
6. After the user has clicked the "Create Team!" button, the user can click the "Get All Team" button on the top left side of the soccer field background to see a list of all Team Players (ordered according to their last name); the user can also click the "Get Starting Lineup" to see a list of the starting lineup.
7. An error message will pop out if the user clicks the "Get All Team" button or "Get Starting Lineup" without creating the Team first (i.e., clicking the "Create Team!" button).

### Design/Model Changes:
Not applicable since this is the first version.

### Assumptions:
Two Players cannot have the same name. If the user enters the same first name and last name, they will be regarded as two different persons and accordingly, two different Player instances will be created.

### Limitations:
The model adopts a simple algorithm to select the starting lineup by choosing the top seven Players with the highest skill levels regardless of their preferred Positions. Once the starting lineup members are chosen, the model will assign Positions by first trying to respect each Player's preference and then randomly assigning unassigned Players to available vacancies. Therefore, the user has no discretion to manipulate the selection and composition of starting lineup, and the results may not match the user's expectations.

Moreover, the starting lineup can only be created once after the team is created. If the user is not satisfied with the members or assigned Positions of Players in the starting lineup, the user cannot make any further adjustments. 

### References:
1. "How to Use GridBagLayout." The Java Tutorials. https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html (accessed April 18, 2023).
2. "Working with Gridbag Layout in Java." Section. https://www.section.io/engineering-education/working-with-gridbag-layout-in-java/ (accessed April 18, 2023).
3. "Get combobox value in Java swing." StackOverflow. https://stackoverflow.com/questions/11999560/get-combobox-value-in-java-swing (accessed April 19, 2023).
4. "How to Use Combo Boxes." The Java Tutorials. https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html (accessed April 19, 2023).
5. "Newline in JLabel." StackOverflow. https://stackoverflow.com/questions/1090098/newline-in-jlabel (accessed April 19, 2023).
6. "How do I add an image to a JButton." StackOverflow. https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton (accessed April 19, 2023).

