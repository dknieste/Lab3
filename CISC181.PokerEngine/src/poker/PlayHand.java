package poker;

import java.util.ArrayList;
import java.util.Collections;

public class PlayHand {

	public static void main(String[] args) {



		for (int gCount = 0; gCount <= 2000000; gCount++) {
			ArrayList<Hand> Hands = new ArrayList<Hand>();
			Deck d = new Deck();

			for (int hCnt = 0; hCnt <= 2; hCnt++) {
				Hand h = new Hand(d);
				h.EvalHand();
				Hands.add(h);
			}
			Collections.sort(Hands, Hand.HandRank);

			System.out
					.print("Hand Strength: " + Hands.get(0).getHandStrength());
			System.out.print(" Hi Hand: " + Hands.get(0).getHighPairStrength());
			System.out.print(" Lo Hand: " + Hands.get(0).getLowPairStrength());
			System.out.print(" Kicker: " + Hands.get(0).getKicker());

			System.out.print(" beats ");

			System.out.print(" Hand Strength: "
					+ Hands.get(1).getHandStrength());
			System.out.print(" Hi Hand: " + Hands.get(1).getHighPairStrength());
			System.out.print(" Lo Hand: " + Hands.get(1).getLowPairStrength());
			System.out.print(" Kicker: " + Hands.get(1).getKicker());

			System.out.print("\n");

		}

	}

}
