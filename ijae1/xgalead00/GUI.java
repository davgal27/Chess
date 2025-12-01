package ijae1.xgalead00;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame{
	 
	private JPanel BoardPanel; // visual board 
	private JLabel[][] squares = new JLabel[8][8]; // individual squares on the board 
	private JTextField InputField; // where the user will type commands 
	private JButton move_button, exit_button; // buttons to execute commands and to exit the paplication
	private JLabel turn; // Shows current player turn 

	private Player current_player = Player.WHITE; // initialize first player as white so then the turns are alternating 

	private ImageIcon GetPieceIcon(Piece piece) {
		if (piece == null) return null;
		String color = (piece.getplayer() == Player.WHITE) ? "w" : "b";
		String name = switch(piece.getpiecename()) {
			case PAWN -> "pawn";
	        case ROOK -> "rook";
	        case KNIGHT -> "knight";
	        case BISHOP -> "bishop";
	        case QUEEN -> "queen";
	        case KING -> "king";
		};
		String path = "/ijae1/xgalead00/images/" + color + "_" + name + ".png";
		return new ImageIcon(getClass().getResource(path));
	}



	public GUI() {
		setTitle("Chess"); //window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when user closes the window the code stops
		setLayout(new BorderLayout());

		ChessBoard.BlankSlate(); // initialize board

		///////// Panel for squares
		JPanel BoardPanel = new JPanel(new GridLayout(8,8));
        int rows = 8;                         
        int columns = 8;

        //Loop to fill the grid; uses the same loop logic as for printing in ChessBoard.java
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
				squares[i][j] = new JLabel("", SwingConstants.CENTER);
				squares[i][j].setOpaque(true);
				squares[i][j].setBackground((i + j) % 2 == 0 ? new Color(237, 232, 208) : new Color(78,120,55)); //same logic as for Chessboard.java for printing the black and white 
				BoardPanel.add(squares[i][j]);
			}
		}
		add(BoardPanel, BorderLayout.CENTER);


	    ///////////// Column labels panel (A-H)
		JPanel ColumnPanel = new JPanel(new GridLayout(1, 8));
		for (int j = 0; j < columns; j++) {
		    JLabel ColLabel = new JLabel(String.valueOf((char)('A' + j)), SwingConstants.CENTER);
		    ColumnPanel.add(ColLabel);
		}
		add(ColumnPanel, BorderLayout.SOUTH);


		///////// Row labels panel (8-1)
		JPanel RowPanel = new JPanel(new GridLayout(8, 1));
		for (int i = 0; i < rows; i++) {
		    JLabel RowLabel = new JLabel(String.valueOf(8 - i), SwingConstants.CENTER);
		    RowLabel.setPreferredSize(new Dimension(30, 0)); // width 30 pixels
		    RowPanel.add(RowLabel);
		}
		add(RowPanel, BorderLayout.WEST);

		// Wrap board + row labels together
		JPanel BoardWithRow = new JPanel(new BorderLayout());
		BoardWithRow.add(RowPanel, BorderLayout.WEST);
		BoardWithRow.add(BoardPanel, BorderLayout.CENTER);

		// Then add column labels above
		JPanel FullBoard = new JPanel(new BorderLayout());
		FullBoard.add(ColumnPanel, BorderLayout.SOUTH);
		FullBoard.add(BoardWithRow, BorderLayout.CENTER);

		// Add everything to frame
		add(FullBoard, BorderLayout.CENTER);

		// turn label 
		turn = new JLabel("Turn: WHITE", SwingConstants.CENTER);
		add(turn, BorderLayout.NORTH);



		//interaction area 
		JPanel InteractionPanel = new JPanel();
		InputField = new JTextField(5); // input field for commands for moves 
		move_button = new JButton("Move"); // move button
		exit_button = new JButton("Exit");

		move_button.addActionListener((ActionEvent e) -> { // move button event listener
			String move = InputField.getText().trim().toUpperCase(); // get input command from text
			if (move.isEmpty()){
				return;
			}
			boolean move_success = ChessBoard.MovePiece(move, current_player);
			if (move_success){
				current_player = (current_player == Player.WHITE) ? Player.BLACK : Player.WHITE; // alternate the players
				turn.setText("Turn: " + current_player); // update turn label at the top

			}

			// update visual board 
	        for(int i = 0; i < rows; i++) { 
	            for (int j = 0; j < columns; j++) {
	            	squares[i][j].setIcon(GetPieceIcon(ChessBoard.ChessBoard[i][j]));
	            	squares[i][j].setText("");
	            	// if (ChessBoard.ChessBoard[i][j] != null){
	            	// 	squares[i][j].setText(ChessBoard.ChessBoard[i][j].toString());
	            	// 	squares[i][j].setForeground(
	            	// 		ChessBoard.ChessBoard[i][j].getplayer() == Player.WHITE ? Color.WHITE : Color.BLACK
	            	// );
	            	// } else {
	            	// 	squares[i][j].setText("");
	            	// }
	            	
	            }
	        }

	        InputField.setText(""); // clear input after turn 
		});

		InputField.addActionListener(e -> move_button.doClick()); // enter clicks the move button 

		exit_button.addActionListener(e -> System.exit(0)); // exit button event listener 

		// Add interaction panel elements to GUI
		InteractionPanel.add(InputField);
		InteractionPanel.add(move_button);
		InteractionPanel.add(exit_button);

		// Add interacion panel to window
		add(InteractionPanel, BorderLayout.SOUTH); // interaction area near the south of the screen

		// Initial board printing
	    for(int i = 0; i < rows; i++) { 
	        for (int j = 0; j < columns; j++) {
	            squares[i][j].setIcon(GetPieceIcon(ChessBoard.ChessBoard[i][j]));
	            squares[i][j].setText("");
	        }
	    }    
	    setSize(1000,1000);
		setVisible(true); 
	}

}