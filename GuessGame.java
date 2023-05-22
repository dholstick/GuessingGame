import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Main Class
public class GuessGame extends JFrame{

// Declare class variables
private static final long serialVersionUID = 1L;
public static Object prompt1;
private JTextField userInput;
private JLabel comment = new JLabel(" ");
private JLabel comment2 = new JLabel(" ");
private int randomNum;
private int counter = 0;

// Constructor
public GuessGame(){
super("Guessing Game");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Content
setLayout(new FlowLayout());
Container c = getContentPane();

// Create components
JButton guessButton = new JButton("Try the number");
JButton newGameButton = new JButton("New Game");
JButton quitButton = new JButton("Quit");
JLabel label1 = new JLabel("I have a number between 1 and 1000.");
JLabel label2 = new JLabel("Can you guess the number?");
JLabel label3 = new JLabel("Please enter your guess: ");
comment = new JLabel(" ");
comment2 = new JLabel(" ");
userInput = new JTextField(5);

// Adding components
c.add(label1);
c.add(label2);
c.add(label3);
c.add(userInput);
c.add(guessButton);
c.add(newGameButton);
c.add(quitButton);
c.add(comment);
c.add(comment2);

// Set the mnemonic
guessButton.setMnemonic('T');
newGameButton.setMnemonic('N');
quitButton.setMnemonic('Q');

//Format
setSize(300, 200);
setLocationRelativeTo(null);
setVisible(true);
setResizable(false);

initializeNumber();

// Create the button handlers
GuessButtonHandler guessHandler = new GuessButtonHandler(); // instantiate
guessButton.addActionListener(guessHandler); // add listener

NewButtonHandler newGamehandler = new NewButtonHandler();
newGameButton.addActionListener(newGamehandler);

QuitButtonHandler quitHandler = new QuitButtonHandler();
quitButton.addActionListener(quitHandler);
} // End constructor

private void initializeNumber(){
randomNum = new Random().nextInt(1000) + 1;
}

// GuessButton inner class
private class GuessButtonHandler implements ActionListener{
public void actionPerformed(ActionEvent e){

// Declare class variables
int getInput;
int diff;
int Difference;

// Validate input and if statements for user input
try {
getInput = Integer.parseInt(userInput.getText().trim());
counter++;

if (getInput == randomNum) {
JOptionPane.showMessageDialog(null, "Correct! It took you "
+ counter + " guesses", "Random Number: "
+ randomNum, JOptionPane.INFORMATION_MESSAGE);
initializeNumber();
return;
}
if (getInput > randomNum) {
comment2.setText("The guess was too HIGH. Try a lower number.");
comment2.setForeground(Color.WHITE);
diff = getInput - randomNum;
Difference = Math.abs(diff);
} else {
comment2.setText("The guess was too LOW. Try a higher number.");
comment2.setForeground(Color.WHITE);
diff = randomNum - getInput;
Difference = Math.abs(diff);
}

if (Difference >= 30) {
comment.setText("You are Cold. ");
comment.setForeground(Color.WHITE);
GuessGame.this.setBackgroundColor(Color.BLUE);
}

if (Difference <= 15) {
comment.setText("You are getting Warm");
comment.setForeground(Color.WHITE);
GuessGame.this.setBackgroundColor(Color.RED);
}
} catch (NumberFormatException ex) {
comment.setText("Enter a VALID number!");
}
}
}   //End handler

// NewButton inner class
private class NewButtonHandler implements ActionListener {
public void actionPerformed(ActionEvent e) {
GuessGame game = new GuessGame();

}
} // End handler

// QuitButton inner class
private class QuitButtonHandler implements ActionListener {
public void actionPerformed(ActionEvent e) {
System.exit(0);
}
} // end handler

// Setting background
private void setBackgroundColor(Color RED) {
getContentPane().setBackground(RED);
}

// Main method
public static void main(String args[]) {
// instantiate GuessGame object
GuessGame game = new GuessGame();

}// End main
}// End main class