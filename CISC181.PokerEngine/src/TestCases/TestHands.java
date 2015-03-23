package TestCases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;

public class TestHands {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * We added a test for every type of hand, plus a few with jokers to make
	 * sure our joker logic is sound.
	 */

	@Test
	public final void TestRoyalFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Royal Flush:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());

	}

	@Test
	public final void TestRoyalFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Royal Flush:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestRoyalFlushJoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Royal Flush:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());

	}

	@Test
	public final void TestStraightFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.NINE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Straight Flush:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFiveOfAKind() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.SPADES, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.TWO));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Five of a Kind:",
				eHandStrength.FiveOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFourOfAKind() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.SPADES, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Four of a Kind:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFullHouse() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.SPADES, eRank.FIVE));
		rfHand.add(new Card(eSuit.HEARTS, eRank.THREE));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.THREE));
		rfHand.add(new Card(eSuit.SPADES, eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Full House:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFlush() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.NINE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Flush:",
				eHandStrength.Flush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestStraight() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.HEARTS, eRank.FIVE));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.SPADES, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Straight:",
				eHandStrength.Straight.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestThreeOfAKind() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.HEARTS, eRank.JACK));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.SPADES, eRank.NINE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Three of a Kind:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeOfAKindJoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.FIVE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Three of a Kind:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestTwoPair() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.HEARTS, eRank.JACK));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.SPADES, eRank.FIVE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Two Pair:",
				eHandStrength.TwoPair.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestPair() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.SPADES, eRank.FIVE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be a Pair:", eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestHighCard() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.HEARTS, eRank.NINE));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.SPADES, eRank.FIVE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be just High Card:",
				eHandStrength.HighCard.getHandStrength(), h.getHandStrength());
	}

}
