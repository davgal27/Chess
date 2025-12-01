package ijae1.xgalead00;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame{
	 
	private JPanel BoardPanel; // visual board 
	private JLabel[][] squares = new JLabel[8][8]; // individual squares on the board 
	private JTextField InputField; // where the user will type commands 
	private JButton move_button, exit_button; // buttons to execute commands and to exit the paplication

	private Player current_player = Player.WHITE; // initialize first player as white so then the turns are alternating 


	public GUI() {
		setTitle("Chess"); //window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when user closes the window the code stops
		setLayout(new BorderLayout());

		ChessBoard.BlankSlate(); // initialize board

		BoardPanel = new JPanel(new GridLayout(8,8));
        int rows = 8;                         
        int columns = 8;

        //Loop to fill the grid; uses the same loop logic as for printing in ChessBoard.java
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
				squares[i][j] = new JLabel("", SwingConstants.CENTER);
				squares[i][j].setOpaque(true);
				squares[i][j].setBackground((i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY); //same logic as for Chessboard.java for printing the black and white 
				BoardPanel.add(squares[i][j]);
			}
		}

		JPanel InteractionPanel = new JPanel();
		InputField = new JTextField(5); // input field for commands for moves 
		move_button = new JButton("Move"); // move button
		exit_button = new JButton("Exit");

		move_button.addActionListener((ActionEvent e) -> { // move button event listener
			String move = InputField.getText().trim().toUpperCase(); // get input command from text
			if (move.isEmpty()){
				return;
			}
			ChessBoard.MovePiece(move, current_player); //calls from ChessBoard.java to move the piece
			current_player = (current_player == Player.WHITE) ? Player.BLACK : Player.WHITE; // alternate the players

			// update visual board 
	        for(int i = 0; i < rows; i++) { 
	            for (int j = 0; j < columns; j++) {
	            	if (ChessBoard.ChessBoard[i][j] != null){
	            		squares[i][j].setText(ChessBoard.ChessBoard[i][j].toString());
	            		squares[i][j].setForeground(
	            			ChessBoard.ChessBoard[i][j].getplayer() == Player.WHITE ? Color.WHITE : Color.BLACK
	            	);
	            	} else {
	            		squares[i][j].setText("");
	            	}
	            	
	            }
	        }

	        InputField.setText(""); // clear input after turn 
		});

		exit_button.addActionListener(e -> System.exit(0)); // exit button event listener 


		// Add interaction panel elements to GUI
		InteractionPanel.add(InputField);
		InteractionPanel.add(move_button);
		InteractionPanel.add(exit_button);

		// Add elements to the window
		add(BoardPanel ,BorderLayout.CENTER);
		add(InteractionPanel, BorderLayout.SOUTH); // interaction area near the south of the screen

		// Initial board printing
	    for(int i = 0; i < rows; i++) { 
	        for (int j = 0; j < columns; j++) {
	            if (ChessBoard.ChessBoard[i][j] != null){
	            	squares[i][j].setText(ChessBoard.ChessBoard[i][j].toString());
	            	squares[i][j].setForeground(
	            		ChessBoard.ChessBoard[i][j].getplayer() == Player.WHITE ? Color.WHITE : Color.BLACK
	            );
	            } else {
	            	squares[i][j].setText("");
	            }
	            	
	        }
	    }    
	    setSize(1000,1000);
		setVisible(true); 
	}

}