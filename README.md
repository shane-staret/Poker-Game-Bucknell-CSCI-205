## Team Name
:crown: King's Disciples :crown:

## Project Description & Explanation
**The final project for Bucknell University's CSCI205 course.**  
This project is a Java application that simulates playing a Texas Hold 'Em Poker game against CPU opponents. The objective of this project was to create a functional Texas Hold 'Em Poker Graphical User Interface (GUI) environment with moderately challenging CPU opponents. Allowing for customization on the player's end was also an important objective.  
  
We mainly separated our work into front-end and back-end designers. Shane and Sami primarily worked on the front-end development, while Mike and John focused on the back-end development. The GUI was built entirely through JavaFX, primarily using the Shape object that this library offers. The backend logic that controlled the aptitude of the CPU opponents was hardcoded (meaning that no true AI or machine learning was used). This would likely be something that we could change in the future, so that we may be able to implement a feature allowing for the player to adjust the CPUs difficulty without us having to hardcode different difficulties, which would be very convoluted and inefficient. 
  
The application follows the below logic:
1. User is brought to the Main Menu
2. (OPTIONAL) User can navigate to the Settings Menu to customize their gameplay experience (colors, starting chip amounts, number of CPU opponents, etc.)
3. User can begin a Poker game from the Main Menu
4. User chooses the name they want to be displayed as
5. All players (the user and the CPU opponents) have their hands dealt to them
6. Players make initial bets or fold
7. The flop is dealt
8. Players make bets or fold (if everyone but one person folds, go to Step 13)
9. The turn is dealt
10. Players make bets or fold (if everyone but one person folds, go to Step 13)
11. The river is dealt
12. Players make bets or fold (if everyone but one person folds, go to Step 13)
13. A winner is determined based on their hand
14. Repeat steps 5 through 13

## Package Explanation
**controller** - This package contains the classes that connect logical data of the application to the GUI.   
  
**game** - This package contains the classes that solely focus on implementing the back-end logic of a Texas Hold 'Em Poker game.   
  
**main** - This package contains the class that drives the entire application. It launches the front-end and back-end of the application.
  
**resources** - This package contains the resources (i.e. images) that the application will use. In this application, the only resources needed were images of every card in a standard deck. 
  
**view** - This package contains the classes that create the GUI.   

## 3rd Parties Used
#### **JavaFX**  
Version Number: 13.0.1  
Description: JavaFX is a GUI library built to be used with Java applications that require a complex User Interface (UI). The UI for this project was entirely built using JavaFX.  
  
#### **JUnit**  
Version Number: 5.5.2  
Description: JUnit is a unit testing library. It is used to test individual methods within varying interconnected classes within a Java application. This is useful because JUnit tests can be used to confirm that a particular method is working, even when other components of the application that it depends on may not be fully implemented. These tests can be used to confirm the solidarity of a particular method and can be extremely helpful when debugging issues.  
  
## Execution Instructions
Using the command line:
1. Clone the repository: `git clone https://github.com/shane-staret/Poker-Game-Bucknell-CSCI-205.git`
2. Go to the directory the repository was cloned into using the `cd` command
3. Navigate to the JAR file: `cd csci205_Kings_Disciples/dist`
4. Execute the JAR file: `java -jar PokerGame.jar`
