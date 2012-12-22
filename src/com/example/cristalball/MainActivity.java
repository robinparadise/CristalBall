package com.example.cristalball;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Declare our view variables
        final TextView answerLabel = (TextView) findViewById(R.id.textView1);
        Button getAnswerButton = (Button) findViewById(R.id.button1);
        
        getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String[] answers = {
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
				// The button was clicked, so update the label text to the answer
				String answer = "";
				
				// Randomly select one of the three answers: YES, NO, MAYBE
				Random randomGenerator = new Random(); // construct a new Random Number Generator
				int randomNumber = randomGenerator.nextInt(answers.length);
				/* Convert the randomNumber to a text answer
				 * 0 = Yes
				 * 1 = No
				 * 2 = Maybe
				 */
				answer = answers[randomNumber];		
				
				// Update the answer with our dinamic answer
				answerLabel.setText(answer);				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
