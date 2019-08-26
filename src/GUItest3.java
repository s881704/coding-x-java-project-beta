import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GUItest3 extends JFrame implements ActionListener {
	private JTextField textField;
	// public int numofDeck = 2;
	private static ArrayList<Card> cards = new ArrayList<Card>(2);
	public int totalnum = 4;
	private static ArrayListPlayer player = new ArrayListPlayer(4);
	private int a = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUItest3 frame = new GUItest3();
		frame.setVisible(true);
		frame.setResizable(false);

		// int rand = new Random().nextInt(52);

	}

	private GUItest3() {

		// setBounds(100, 100, 515, 415);
		setBounds(100, 100, 505, 515);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Dealer");
		label.setBounds(417, 47, 46, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Player1");
		label_1.setBounds(417, 117, 46, 15);
		getContentPane().add(label_1);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.BOLD, 20));
		textArea.setBounds(23, 36, 361, 36);
		getContentPane().add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.BOLD, 20));
		textArea_1.setBounds(23, 106, 361, 36);
		getContentPane().add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Arial", Font.BOLD, 20));
		textArea_2.setBounds(23, 173, 361, 36);
		getContentPane().add(textArea_2);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Arial", Font.BOLD, 20));
		textArea_3.setBounds(23, 235, 361, 36);
		getContentPane().add(textArea_3);

		

		JLabel label_2 = new JLabel("Player2");
		label_2.setBounds(417, 184, 46, 15);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Player3");
		label_3.setBounds(417, 246, 46, 15);
		getContentPane().add(label_3);

		textField = new JTextField();
		textField.setBounds(23, 427, 440, 40);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("How many decks:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBackground(new Color(51, 0, 0));
		lblNewLabel.setBounds(23, 358, 123, 65);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Deck");
		btnNewButton.setBounds(378, 403, 87, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Player");
		btnNewButton_1.setBounds(281, 403, 87, 23);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(281, 358, 87, 34);
		getContentPane().add(lblNewLabel_1);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(378, 358, 85, 34);
		getContentPane().add(label_4);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				int numofDeck = Integer.parseInt(str);
				ArrayList<Card> cards = Card.createDeck(numofDeck);
				Card.shuffleDeck(cards);
				lblNewLabel.setText("How many players:");
				label_4.setText(str + " Deck(s)");

			}

		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str2 = textField.getText();
				int totalnum = Integer.parseInt(str2) + 1;
				lblNewLabel_1.setText(str2 + " Player(s)");
				ArrayListPlayer player = new ArrayListPlayer(totalnum);
				player.clearHand(4);
			}

		});
		JButton btn_start = new JButton("Start");
		btn_start.setBounds(23, 325, 85, 23);
		getContentPane().add(btn_start);

		JButton btnNewButton_2 = new JButton("Clear handcards");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 1;
				player.clearHand(4);
				String name0 = "Player0";
				textArea.setText("");
				String name1 = "Player1";
				textArea_1.setText("");
				String name2 = "Player2";
				textArea_2.setText("");
				String name3 = "Player3";
				textArea_3.setText("");
				String test = "<html><body>Player1 sum = " + player.handValue(name1) + "<br/>" + "Player2 sum = "
						+ player.handValue(name2) + "<br/>" + "Player3 sum = " + player.handValue(name3) + "<br/>"
						+ "</body></html>";
				lblNewLabel.setText(test);

			}
		});
		btnNewButton_2.setBounds(268, 292, 195, 23);
		getContentPane().add(btnNewButton_2);
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards = Card.createDeck(2);
				Card.shuffleDeck(cards);
				player.sendCard(4, cards);
				String name0 = "Player0";
				player.printHandText(name0, textArea);
				String name1 = "Player1";
				player.printHandText(name1, textArea_1);
				String name2 = "Player2";
				player.printHandText(name2, textArea_2);
				String name3 = "Player3";
				player.printHandText(name3, textArea_3);

				String test = "<html><body>Player1 sum = " + player.handValue(name1) + "<br/>" + "Player2 sum = "
						+ player.handValue(name2) + "<br/>" + "Player3 sum = " + player.handValue(name3) + "<br/>"
						+ "Player1 turn" + "</body></html>";
				lblNewLabel.setText(test);
				
				if (player.handValue(name0) == 21) {
					lblNewLabel.setText("The dealer is winner!");
				}else if(player.handValue(name1) == 21){
					lblNewLabel.setText("The player1 is winner!");
				}else if(player.handValue(name2) == 21){
					lblNewLabel.setText("The player2 is winner!");
				}else if(player.handValue(name3) == 21){
					lblNewLabel.setText("The player3 is winner!");
				}
				
			}
		});
		JButton btn_get = new JButton("Wager");
		btn_get.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (a == 1) {
					a = a + 1;
					String name1 = "Player1";
					player.extraCard(name1, cards);
					textArea_1.setText("");
					player.printHandText(name1, textArea_1);
					player.handValue2(name1, lblNewLabel);
					if(player.handValue(name1) == 21){
						lblNewLabel.setText("The player1 is winner!");
					}
				} else if (a == 2) {
					a = a + 1;
					String name2 = "Player2";
					player.extraCard(name2, cards);
					textArea_2.setText("");
					player.printHandText(name2, textArea_2);
					player.handValue2(name2, lblNewLabel);
					if(player.handValue(name2) == 21){
						lblNewLabel.setText("The player2 is winner!");
					}
				} else if (a == 3) {
					a = a - 2;
					String name3 = "Player3";
					player.extraCard(name3, cards);
					textArea_3.setText("");
					player.printHandText(name3, textArea_3);
					player.handValue2(name3, lblNewLabel);
					if(player.handValue(name3) == 21){
						lblNewLabel.setText("The player3 is winner!");
					}
				}
			}
		});
		btn_get.setBounds(148, 325, 85, 23);
		getContentPane().add(btn_get);

		JButton btn_stop = new JButton("Hit");
		btn_stop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (a == 1) {
					a = a + 1;
					String name1 = "Player1";
					player.handValue2(name1, lblNewLabel);
				} else if (a == 2) {
					a = a + 1;
					String name2 = "Player2";
					player.handValue2(name2, lblNewLabel);
				} else if (a == 3) {
					String name3 = "Player3";
					a = a - 2;
					player.handValue2(name3, lblNewLabel);
				}
			}
		});
		btn_stop.setBounds(268, 325, 85, 23);
		getContentPane().add(btn_stop);

		JButton btnNewButton_3 = new JButton("Dealer button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "Player0";
				player.extraCardComputer(cards);
				textArea.setText("");
				player.printHandText(name, textArea);
				if(player.handValue(name)==21) {
					lblNewLabel.setText("The dealer win!");
				}else if(player.handValue(name)>21) {
					lblNewLabel.setText("The dealer lose!");
				}
			}
		});
		btnNewButton_3.setBounds(23, 292, 195, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(130, 403, 115, 20);
		getContentPane().add(lblNewLabel_2);
			
		JLabel label_5 = new JLabel("");
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setBounds(130, 388, 115, 20);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setVerticalAlignment(SwingConstants.BOTTOM);
		label_6.setBounds(130, 373, 115, 20);
		getContentPane().add(label_6);
		
		JButton btnNewButton_4 = new JButton("Result");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "Player0";
				String name1 = "Player1";
				String name2 = "Player2";
				String name3 = "Player3";
				String test1 = "<html><body>Dealer sum = " + player.handValue(name) + "<br/>" + "Player1 sum = "
						+ player.handValue(name1) + "<br/>" + "Player2 sum = " + player.handValue(name2) + "<br/>"
						+ "Player3 sum = " + player.handValue(name3) + "</body></html>";
				lblNewLabel.setText(test1);
				
				player.winLose2(name3);
				player.winLose2(name2);
				player.winLose2(name1);
			}
		});
		btnNewButton_4.setBounds(281, 370, 182, 23);
		getContentPane().add(btnNewButton_4);
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUItest3 frame = new GUItest3();
				frame.setVisible(true);
				frame.setResizable(false);
				a = 1;
				
			}
		});
		btn_reset.setBounds(378, 325, 85, 23);
		getContentPane().add(btn_reset);
	}

	public void actionPerformed(ActionEvent e) {
		// implement button listener
	}
}