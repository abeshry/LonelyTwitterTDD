package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;

public class AbstractTweetTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public AbstractTweetTest() {
		super(LonelyTwitterActivity.class);
	}

	public void testfiveisfive() {
		assertEquals("FIVE IS FIVE", 5, 5);
	}

	public void testTweet() {
		// =========initial test==============
		Tweet t = new Tweet("Hello");
		String actual = t.getTweetBody();

		Tweet t2 = new Tweet("Hello");

		assertEquals("TWEETS THE SAME", "Hello", actual);
		assertEquals("TWEETS THE SAME", t, t2);
		// =========end initial test============
	}

	// ==================test add tweet====================

	public void testAddTweet() {
		TweetListModel testerTweet = new TweetListModel();

		Tweet dup1 = new Tweet("TEST TWEET 1");
		Tweet dup2 = new Tweet("TEST TWEET 2");
		Tweet dup3 = new Tweet("TEST TWEET 1");
		testerTweet.addTweet(dup1);
		testerTweet.addTweet(dup2);
		try {
			testerTweet.addTweet(dup3);
			fail("No exception");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	// =====================Test Get Count====================
	public void testGetCount() {
		TweetListModel testerTweet = new TweetListModel();

		int counter = 0;
		Tweet count1 = new Tweet("TEST TWEET 1");
		counter++;
		Tweet count2 = new Tweet("TEST TWEET 2");
		counter++;
		Tweet count3 = new Tweet("TEST TWEET 3");
		counter++;
		testerTweet.addTweet(count1);
		testerTweet.addTweet(count2);
		testerTweet.addTweet(count3);

		assertEquals("THEY ARE THE SAME", testerTweet.getCount(), counter);

	}

	// ======================Test Has Tweet=======================
	public void testHasTweet() {
		TweetListModel testerTweet = new TweetListModel();

		Tweet has1 = new Tweet("TEST TWEET 1");
		testerTweet.addTweet(has1);

		boolean have = testerTweet.hasTweet(has1);
		assertEquals("WE HAVE THIS TWEET", true, have);
	}

	// ======================Test Has Tweet=======================
	public void testRemoveTweet() {
		TweetListModel testerTweet = new TweetListModel();

		Tweet remove1 = new Tweet("TEST TWEET 1");
		testerTweet.addTweet(remove1);

		boolean have = testerTweet.hasTweet(remove1);
		assertEquals("WE HAVE THIS TWEET", true, have);

		testerTweet.removeTweet(remove1);

		boolean rem = testerTweet.hasTweet(remove1);
		assertEquals("WE DO NOT HAVE THIS TWEET", false, rem);
	}

	// ======================Test Has Tweet=======================
	public void testClearTweet() {
		TweetListModel testerTweet = new TweetListModel();

		Tweet count1 = new Tweet("TEST TWEET 1");
		Tweet count2 = new Tweet("TEST TWEET 2");
		Tweet count3 = new Tweet("TEST TWEET 3");
		testerTweet.addTweet(count1);
		testerTweet.addTweet(count2);
		testerTweet.addTweet(count3);
		testerTweet.clear();
		assertEquals("CLEAR LIST OF TWEETS", 0, testerTweet.getCount());
	}
	
}
