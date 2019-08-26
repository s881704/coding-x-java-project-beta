import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ArrayListPlayer {
	private int n;
	private HashMap<String, ArrayList<Card>> playerlist = new HashMap<String, ArrayList<Card>>();
	private ArrayList<Card> cards = new ArrayList<Card>();

	public ArrayListPlayer(int n) {
		this.n = n;
		for (int i = 0; i < n; i++) {
			playerlist.put("Player" + String.valueOf(i), new ArrayList<Card>());
		}
	}

	void getList(String name) {
		System.out.println(playerlist.get(name));
	}

	// �P���}�l�o2�i�P
	public void sendCard(int n, ArrayList<Card> cards) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				Card curr = cards.get(0);
				playerlist.get("Player" + String.valueOf(i)).add(curr);
				cards.remove(0);
				// System.out.println("��" + j + "�i�P");
			}
		}
	}

	// �[�P
	public void extraCard(String name, ArrayList<Card> cards) {
		Card curr = cards.get(0);
		playerlist.get(name).add(curr);
		cards.remove(0);
		// System.out.println("��" + j + "�i�P");
	}

	// �q���[�P
	public void extraCardComputer(ArrayList<Card> cards) {
		if (handValue("Player0") < 16)
			;
		extraCard("Player0", cards);
	}

	// �L�X���P
	public void printHand(String name) {
		if (name == "Player0") {
			System.out.println(name + ":");
			System.out.println("The 1 card: *");
			for (int j = 1; j < playerlist.get(name).size(); j++) {
				System.out.print("The " + (j + 1) + " card: ");
				System.out.println(playerlist.get(name).get(j).getIconMask() + playerlist.get(name).get(j).getMask());
			}
		} else {
			System.out.println(name + ":");
			for (int j = 0; j < playerlist.get(name).size(); j++) {
				System.out.print("The " + (j + 1) + " card: ");
				System.out.println(playerlist.get(name).get(j).getIconMask() + playerlist.get(name).get(j).getMask());
			}
		}

	}

	public void printHandText(String name, JTextArea textArea) {
		if (name == "Player0") {
			textArea.append("*" + " , ");
			for (int j = 1; j < playerlist.get(name).size(); j++) {
				textArea.append(
						playerlist.get(name).get(j).getIconMask() + playerlist.get(name).get(j).getMask() + " , ");
			}
		} else {
			for (int j = 0; j < playerlist.get(name).size(); j++) {
				textArea.append(
						playerlist.get(name).get(j).getIconMask() + playerlist.get(name).get(j).getMask() + " , ");
			}
		}
	}

	// Judge A = 11 or 1
	public int handValue(String name) {
		int sum = 0;
		int ace = 0;
		for (int j = 0; j < playerlist.get(name).size(); j++) {
			sum = sum + playerlist.get(name).get(j).getValue();
			// Judge whether A exist or not
			if (playerlist.get(name).get(j).getMask() == "A") {
				ace++;
			}
		}
		// As insert A,the sum minus 10, until<21
		if (sum > 21 && ace > 0) {
			for (int i = 0; sum > 21; i++) {
				sum = sum - (ace - i) * 10;
			}
			// System.out.print(name + " sum: " + sum);
		} else {
			// System.out.println("You are loser!");
		}

		return sum;

	}

	public int handValue2(String name, JLabel lblNewLabel) {
		int sum = 0;
		int ace = 0;
		for (int j = 0; j < playerlist.get(name).size(); j++) {
			sum = sum + playerlist.get(name).get(j).getValue();
			// Judge whether A exist or not
			if (playerlist.get(name).get(j).getMask() == "A") {
				ace++;
			}
		}
		// As insert A,the sum minus 10, until<21
		if (sum > 21 && ace > 0) {
			for (int i = 0; sum > 21; i++) {
				sum = sum - i * 10;
			}
			// System.out.print(name + " sum: " + sum);
		}
		if (sum <= 21 && name != "Player0:") {
			lblNewLabel.setText("<html><body>" + name + " sum: " + sum + "<br/>" + "Next turn" + "<html><body>");
		} else {
			lblNewLabel.setText("You are loser!");
		}

		return sum;

	}

	// �C�L�I��
	public void printValue(String name) {
		System.out.println(handValue(name));
	}

	// �P�_��Ĺ
	public void winLose(String name) {
		if (handValue(name) > handValue("Player0")) {
			System.out.println(name + "Ĺ���a");
		} else if (handValue(name) < handValue("Player0")) {
			System.out.println(name + "�����a");
		} else {
			System.out.println(name + "�M���a����");
		}

	}

	public void winLose3(String name, JLabel lblNewLabel_2) {
		if (handValue(name) > handValue("Player0") || handValue("Player0") > 21) {
			lblNewLabel_2.setText("Win to the dealer !");
		} else if (handValue(name) < handValue("Player0")) {
			lblNewLabel_2.setText("Lose to the dealer !");
		} else {
			lblNewLabel_2.setText("Flat to the dealer !");
		}

	}

	public void clearHand(int n) {
		for (int i = 0; i < n; i++) {
			playerlist.get("Player" + String.valueOf(i)).clear();
		}
	}

	public void winLose2(String name) {
		if (handValue(name) <= 21 & handValue(name) > handValue("Player0")) {
			String A = name + "Win to the dealer !";
			JOptionPane.showMessageDialog(null, A);
		}
		if (handValue(name) > 21 & handValue("Player0") <= 21) {
			String B = name + "Lose to the dealer !";
			JOptionPane.showMessageDialog(null, B);
		}
		if (handValue(name) == handValue("Player0")) {
			String C = name + "Flat to the dealer !";
			JOptionPane.showMessageDialog(null, C);
		}
		if (handValue("Player0") > 21 & handValue(name) > 21) {
			String D = name + "Flat to the dealer !";
			JOptionPane.showMessageDialog(null, D);
		}
		if (handValue(name) <= 21 & handValue("Player0") > 21) {
			String E = name + "Win to the dealer !";
			JOptionPane.showMessageDialog(null, E);
		}
		if (handValue(name) < 21 & handValue(name) < handValue("Player0") & handValue("Player0") <= 21) {
			String F = name + "Lose to the dealer !";
			JOptionPane.showMessageDialog(null, F);
		}
	}
}
