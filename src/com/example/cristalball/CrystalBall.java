package com.example.cristalball;

import java.util.Random;

public class CrystalBall {
	// Member variables (properties about the object)
	public String[] mAnswers = {
			"It is certain",
			"It is decidedly so",
			"All signs say YES",
			"The stars are not aligned",
			"My reply is no",
			"It is doubtful",
			"Better not tell you now",
			"Concentrate and ask again",
			"Unable to answer now",
			"It is hard to say"};
	
	// Methods (abilities: things the object can do)
	public String getAnAnswer() {
		// The button was clicked, so update the label text to the answer
		String answer = "";
		
		// Randomly select one of the three answers: YES, NO, MAYBE
		Random randomGenerator = new Random(); // construct a new Random Number Generator
		int randomNumber = randomGenerator.nextInt(mAnswers.length);
		/* Convert the randomNumber to a text answer
		 * 0 = Yes
		 * 1 = No
		 * 2 = Maybe
		 */
		answer = mAnswers[randomNumber];	
		
		return answer;
	};
}
