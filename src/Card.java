import java.util.ArrayList;
import java.util.Collections;

public class Card {
	private String mask;
	private int value;
	private int icon;
	private String iconMask;
	private boolean isShow;
	private static ArrayList<Card> cards = new ArrayList<Card>();

	// Card建構子
	public Card(String mask, int value, int icon, String iconMask, boolean isShow) {
		this.mask = mask;
		this.value = value;
		this.icon = icon;
		this.iconMask = iconMask;
		this.isShow = isShow;
	}

	// 洗牌
	public static void shuffleDeck(ArrayList<Card> card) {
		Collections.shuffle(card);
	}

	// 創建牌堆 cards :花色、值，
	public static ArrayList<Card> createDeck(int numofDeck) {
		for (int a = 0; a < numofDeck ; a++) {
			for (int icon = 1; icon < 5; icon++) {
				int index = 0;
				String iconMask = "";
				// 初始化花色、字標
				if (icon == 1) {
					index = 0;
					iconMask = "♥";
				} else if (icon == 2) {
					index = 13;
					iconMask = "♦";
				} else if (icon == 3) {
					index = 26;
					iconMask = "♠";
				} else if (icon == 4) {
					index = 39;
					iconMask = "♣";
				}
				for (int i = index; i < index + 13; i++) {
					if (i == index + 0) {
						Card c = new Card("A", i - index + 11, icon, iconMask, true);
						cards.add(c);
					} else if (i > index && i < 10 + index) {
						Card c = new Card(String.valueOf(i + 1 - index), i - index + 1, icon, iconMask, true);
						cards.add(c);
					} else if (i >= 10 + index && i < 13 + index) {

						if (i == 10 + index) {
							Card c = new Card("J", 10, icon, iconMask, true);
							cards.add(c);
						} else if (i == 11 + index) {
							Card c = new Card("Q", 10, icon, iconMask, true);
							cards.add(c);
						} else if (i == 12 + index) {
							Card c = new Card("K", 10, icon, iconMask, true);
							cards.add(c);
						}
					}
				}
			}
		}

		return cards;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getIconMask() {
		return iconMask;
	}

	public void setIconMask(String iconMask) {
		this.iconMask = iconMask;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
