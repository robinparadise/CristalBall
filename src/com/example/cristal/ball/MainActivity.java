package com.example.cristal.ball;

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
        
        // Declare some variables
        final TextView answerLabel = (TextView) findViewById(R.id.textView1);
        Button getAnswerButton = (Button) findViewById(R.id.button1);
        
        getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// The Button was clicked, so update the label with an anwser.
				String answer = "";
				
				// Random select three answers: Yes, No, Maybe
				Random randomGenerator =  new Random(); //Construct a new random number generator
				int randomNumber = randomGenerator.nextInt(3);
				answer = Integer.toString(randomNumber);
				
				// Update the label with a dinamic answer
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
