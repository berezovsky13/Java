package tictctoe;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		//Scanner input = new Scanner(System.in); 
		TicTacToe game = new TicTacToe();
		String player = " X ";
		while(true) {
			System.out.println(game.printBoard());
			
			String strNum = JOptionPane.showInputDialog("Please enter coordinates for rows");
			
			int row = Integer.parseInt(strNum);
			
			String strNum2 = JOptionPane.showInputDialog("Please enter coordinates for colums");
			
			int colums = Integer.parseInt(strNum2);
           
			game.setPlay(row, colums, player);
           
			if(game.isGameOver()){
            
				//JOptionPane.showMessageDialog(null, game.printBoard() +   player + "Wins!!!");
            	System.out.println(game.printBoard() + "\n" +  "We Have a Winner!!!");
            	System.out.println(game.printBoard());
            	break;
            }
            if(player==" X ") {
            	player=" O ";
            }else {
            	player=" X ";
            }
            		
		
		}
		
		

	}

}
