package ca.yorku.cse.mack.UiStudy;


import java.util.Random;

import ca.yorku.cse.mack.UiStudy.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
* Rohan Likhite UiStudy
*/

@SuppressWarnings("unused")
public class UiStudy extends Activity
{
	private final static String MYDEBUG = "MYDEBUG"; // for Log.i messages
	
	
	final static String BUTTON_CLICK_STRING = "button_click_string"; 
	

	ImageButton backspaceButton, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive;
	TextView debugStringStatus, topTextStatus;
	


	String debugString, topTextString;
	boolean testStart = false;
	
	
	final static int TOTALBUTTONPRESSES = 3;
	int buttonCount;
	int nextButton;
	
	long startTime, endTime;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
	}

	private void init()
	{

		
		buttonOne = (ImageButton)findViewById(R.id.oneButton);
		buttonTwo = (ImageButton)findViewById(R.id.twoButton);
		buttonThree = (ImageButton)findViewById(R.id.threeButton);
		buttonFour = (ImageButton)findViewById(R.id.fourButton);
		buttonFive = (ImageButton)findViewById(R.id.fiveButton);
		
		
		
		topTextStatus = (TextView)findViewById(R.id.topText);
		debugStringStatus = (TextView)findViewById(R.id.debugStatus);

	
		topTextString = "Press the first button to begin";
		topTextStatus.setText(topTextString);
		debugString = "";
		

		buttonCount = 0;
		
		//This line sets the colour of the background (outside of layout) to a wonderful green color. 
		//The same color was applied to the layout in main.XML	
		
		getWindow().getDecorView().setBackgroundColor(Color.rgb(0, 0, 255));
	}

	// handle button clicks
	public void buttonClick(View v)
	{
		
		
		
		if(v == buttonOne && !testStart){
			testStart = true;
			Log.i(MYDEBUG, "Test Start");
			startTime =  System.currentTimeMillis();
			debugString = "One";
			debugStringStatus.setText(debugString);	
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(121, 189, 143));
			
			
			
		}
		
		else if (v == buttonOne && testStart && nextButton == 1)
		{
			debugString += "One";
			debugStringStatus.setText(debugString);	
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(121, 189, 143));
				
			
		}
		else if (v == buttonTwo && testStart && nextButton == 2)
		{
			debugString += "Two";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(121, 189, 143));
		}
		else if (v == buttonThree && testStart && nextButton == 3)
		{
			debugString += "Three";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(121, 189, 143));
		}
		else if (v == buttonFour && testStart && nextButton == 4)
		{
			debugString += "Four";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(121, 189, 143));
		}
		else if (v == buttonFive && testStart && nextButton == 5)
		{
			debugString += "Five";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(121, 189, 143));
		}
		else {
			topTextStatus.setText("Please try to press " + nextButton);
			getWindow().getDecorView().setBackgroundColor(Color.rgb(255, 0, 0));
		}

		if(buttonCount == TOTALBUTTONPRESSES){
			buttonCount = 0;
			testStart = false;
			Log.i(MYDEBUG, "Test End");
			endTime =  System.currentTimeMillis();
			
			debugString = "Time Elapsed: ";
			debugStringStatus.setText(debugString + ((endTime - startTime) / 1000));
			topTextStatus.setText("Press Button 1 to Start Trial");
			Log.i(MYDEBUG, "Reset after trial" + topTextStatus.getText());
			getWindow().getDecorView().setBackgroundColor(Color.rgb(0, 0, 255));
		}
	}
	
	public int getNextButton(int i){
		int output = 0;
		
		if(buttonCount < TOTALBUTTONPRESSES){
			
		Random generator = new Random(); 
		output = generator.nextInt(6 - i) + i;
		nextButton = output;
		buttonCount++;		
		}
		
		
		return output;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState)
	{
		Log.i(MYDEBUG, "onSaveInstanceState!");
		
		/*savedInstanceState.putString(BUTTON_CLICK_STRING, buttonClickString);
		
		savedInstanceState.putString(CHECK_BOX_STRING, checkBoxClickString);
		
		savedInstanceState.putString(COLOUR_STRING, colourString);
		
		savedInstanceState.putString(TOGGLE_STRING, toggleString);
		
		savedInstanceState.putString(BACKSPACE_STRING, backspaceString);
		*/
		
		super.onSaveInstanceState(savedInstanceState);
	}
	/* calling an onRestoreInstanceState allows us to retrive the values we previously
	 * stored. 
	 */
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState)
	{
		Log.i(MYDEBUG, "onRestoreInstanceState!");
		super.onRestoreInstanceState(savedInstanceState);
		
		debugStringStatus.setText(debugString);
	}
}