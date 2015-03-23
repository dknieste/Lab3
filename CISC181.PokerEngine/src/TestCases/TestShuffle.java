package TestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.Deck;
import poker.Hand;

public class TestShuffle {

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

	@Test
	public final void TestShuffle() {

		//int HandResult[] = new int[10];
		double[][] HandResult = new double[][]{
				  { 0, 50.1 },
				  { 0, 42.3 },
				  { 0, 4.75 },
				  { 0, 2.11 },
				  { 0, 0.392 },
				  { 0, 0.197 },
				  { 0, 0.144 },
				  { 0, 0.0240 },
				  { 0, 0.00139 },
				  { 0, 0.000154 }
				};
		int NbrOfTrials = 19500000;

		for (int x = 0; x < NbrOfTrials; x++) {
			Deck d = new Deck();
			Hand h = new Hand(d);
			h.EvalHand();

			switch (h.getHandStrength()) {

			case 10: {
				HandResult[0][0] += 1;
				break;
			}
			case 20: {
				HandResult[1][0] += 1;
				break;
			}

			case 30: {
				HandResult[2][0] += 1;
				break;
			}

			case 40: {
				HandResult[3][0] += 1;
				break;
			}

			case 50: {
				HandResult[4][0] += 1;
				break;
			}

			case 60: {
				HandResult[5][0] += 1;
				break;
			}

			case 70: {
				HandResult[6][0] += 1;
				break;
			}

			case 80: {
				HandResult[7][0] += 1;
				break;
			}

			case 90: {
				HandResult[8][0] += 1;
				break;
			}

			case 100: {
				HandResult[9][0] += 1;
				break;
			}
			}
		}
		
		System.out.print("Number of Hi Card Hands           :"
				+ HandResult[0][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[0][0] / (double)NbrOfTrials) * 100) ;
		//assertEquals("Hi Hand out of tolorance:",(long)HandResult[0][1],(long)((double)HandResult[0][0] / (double)NbrOfTrials) * 100);

		System.out.print("Number of Pairs                   :"
				+ HandResult[1][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[1][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Two Pairs               :"
				+ HandResult[2][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[2][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Three of a Kind         :"
				+ HandResult[3][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[3][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Straight                :"
				+ HandResult[4][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[4][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Flush                   :"
				+ HandResult[5][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[5][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Full House              :"
				+ HandResult[6][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[6][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Four Of A Kind          :"
				+ HandResult[7][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[7][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Straight Flush          :"
				+ HandResult[8][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[8][0] / (double)NbrOfTrials) * 100) ;

		System.out.print("Number of Royal Flush             :"
				+ HandResult[9][0]);
		System.out.printf(".....win %4.8f %%" + "\n", ((double)HandResult[9][0] / (double)NbrOfTrials) * 100) ;
		
	}

}
