package com.example.cristalball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cristalball.ShakeDetector.OnShakeListener;

public class MainActivity extends Activity {

	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView mAnswerLabel;
	private ImageView mCrystalBallImage;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakedetector;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Declare our view variables
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mCrystalBallImage = (ImageView) findViewById(R.id.imageView1);
        
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakedetector = new ShakeDetector(new OnShakeListener() {
			
        	public void onShake() {
				handleNewAnswer();
			}
		});
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	mSensorManager.registerListener(mShakedetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	mSensorManager.unregisterListener(mShakedetector);
    }
    
    private void animateCrystalBall() {
    	mCrystalBallImage.setImageResource(R.drawable.ball_animation);
    	AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
    	if (ballAnimation.isRunning()) {
    		ballAnimation.stop();
    	}
    	ballAnimation.start();
    }
    
    private void animateAnswer() {
    	AlphaAnimation fadeAnimation = new AlphaAnimation(0, 1);
    	fadeAnimation.setDuration(1500);
    	fadeAnimation.setFillAfter(true);
    	
    	mAnswerLabel.setAnimation(fadeAnimation);
    }
    
    private void playSound() {
    	MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
    	player.start();
    	player.setOnCompletionListener(new OnCompletionListener() {
			
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	private void handleNewAnswer() {
		String answer = mCrystalBall.getAnAnswer();
		
		// Update the answer with our dinamic answer
		mAnswerLabel.setText(answer);
		// Animate the crystal ball
		animateCrystalBall();
		animateAnswer();
		playSound();
	}
}
