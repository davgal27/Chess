package ijae1.xgalead00;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ChessObserver {
	 
	private JPanel BoardPanel; // visual board 
	private JLabel[][] squares = new JLabel[8][8]; // individual squares on the board 
	private JTextField InputField; // where the user will type commands 
	private JButton move_button, exit_button; // buttons to execute commands and to exit the paplication


	public GUI() {
		setTitle("Chess"); //window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when user closes the window the code stops
		setLayout(new BorderLayout());

		BoardPanel = new JPanel(new GridLayout(8,8));
        int rows = 8;                         
        int columns = 8;

        //Loop to fill the grid; uses the same loop logic as for printing in ChessBoard.java
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
			
			squares[i][j] = new JLabel("", SwingConstants.CENTER);
			squares[i][j].setOpaque(true);
			squares[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.DARK_GRAY); //same logic as for Chessboard.java for printing the black and white 
			BoardPanel.add(squares[i][j]);
			}
		}

		JPanel InteractionPanel = new JPanel();
		InputField = new JTextField(5); // input field for commands for moves 
		move_button = new JButton("Move"); // move button
		exit_button = new JButton("Exit");

		move_button.addActionListener((ActionEvent e) -> {
			ChessBoard.MovePiece(InputField.getText()); // get input command from text
		});


		// Add interaction panel elements to GUI
		InteractionPanel.add(InputField);
		InteractionPanel.add(move_button);
		InteractionPanel.add(exit_button);

		// Add elements to the window
		add(BoardPanel ,BorderLayout.CENTER);
		add(InteractionPanel, BorderLayout.SOUTH); // interaction area near the south of the screen
		setVisible(true); 
		setSize(1000,1000);
	}

	@Override
	public void update(Piece[][] board) {
		int rows = 8;                         
        int columns = 8;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
            	if (board[i][j] != null)
            		squares[i][j].setText(board[i][j].toString());
            	else
            		squares[i][j].setText("");
            }
        }
	}
}