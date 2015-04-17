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
import android.widget.LinearLayout;
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
	
	
	final static int TOTALBUTTONPRESSES = 20;
	int errorCount = 0;
	int buttonCount;
	int nextButton;
	
	int currentTrial = 1;
	
	int trialMode = 1;
	
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
		
		ImageButton imgBtn1 = buttonOne;
		LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) imgBtn1.getLayoutParams();
		params1.setMargins(220, 0, 0, 0); 
		imgBtn1.setLayoutParams(params1);
		
		ImageButton imgBtn2 = buttonTwo;
		LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) imgBtn2.getLayoutParams();
		params2.setMargins(140, 0, 0, 0); 
		imgBtn2.setLayoutParams(params2);
		
		ImageButton imgBtn3 = buttonThree;
		LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) imgBtn3.getLayoutParams();
		params3.setMargins(80, 0, 0, 0); 
		imgBtn3.setLayoutParams(params3);
		
		ImageButton imgBtn4 = buttonFour;
		LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) imgBtn4.getLayoutParams();
		params4.setMargins(0, 0, 0, 0); 
		imgBtn4.setLayoutParams(params4);
		
		ImageButton imgBtn5 = buttonFive;
		LinearLayout.LayoutParams params5 = (LinearLayout.LayoutParams) imgBtn5.getLayoutParams();
		params5.setMargins(-80, 0, 0, 0); 
		imgBtn5.setLayoutParams(params5);
	
		
		topTextStatus = (TextView)findViewById(R.id.topText);
		debugStringStatus = (TextView)findViewById(R.id.debugStatus);

	
		topTextString = "Press Button 1 to Begin the Test";
		topTextStatus.setText(topTextString);
		
		debugStringStatus.setTextColor(Color.parseColor("#FFFFFF"));
		debugString = "Trial";
		debugStringStatus.setText(debugString + currentTrial);

		buttonCount = 0;
		
	
		
		//This line sets the colour of the background (outside of layout) to a wonderful green color. 
		//The same color was applied to the layout in main.XML	
		
		getWindow().getDecorView().setBackgroundColor(Color.rgb(255, 86, 34));
	}

	// handle button clicks
	public void buttonClick(View v)
	{
		
		
		
		if(v == buttonOne && !testStart){
			testStart = true;
			errorCount = 0;
			Log.i(MYDEBUG, "Test Start");
			startTime =  System.currentTimeMillis();
			debugString = "One";
			debugStringStatus.setText(debugString);
			
			Log.i(MYDEBUG, "getNextButton: " + getNextButton(1));
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(139, 195, 74));
			
			
			
		}
		
		else if (v == buttonOne && testStart && nextButton == 1)
		{
			Log.i(MYDEBUG, "Second 1st");
			debugString += "One";
			debugStringStatus.setText(debugString);	
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(139, 195, 74));
				
			
		}
		else if (v == buttonTwo && testStart && nextButton == 2)
		{
			debugString += "Two";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(139, 195, 74));
		}
		else if (v == buttonThree && testStart && nextButton == 3)
		{
			debugString += "Three";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(139, 195, 74));
		}
		else if (v == buttonFour && testStart && nextButton == 4)
		{
			debugString += "Four";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(139, 195, 74));
		}
		else if (v == buttonFive && testStart && nextButton == 5)
		{
			debugString += "Five";
			debugStringStatus.setText(debugString);
			topTextStatus.setText("Press Button " + getNextButton(1));
			getWindow().getDecorView().setBackgroundColor(Color.rgb(139, 195, 74));
		}
		else {
			topTextStatus.setText("Please try to press " + nextButton);
			errorCount++;
			
			Log.i(MYDEBUG, "Error Count: " +  errorCount);
			getWindow().getDecorView().setBackgroundColor(Color.rgb(244, 67, 54));
		}

		if(buttonCount == TOTALBUTTONPRESSES && currentTrial <3){
			
			buttonCount = 0;
			testStart = false;
			Log.i(MYDEBUG, "Trial End");
			endTime =  System.currentTimeMillis();
			
				
			//debugString = "Time Elapsed: ";
			debugStringStatus.setText("Mode: " + trialMode + " | " + "Trial: " + currentTrial + " | " + "Error : " + errorCount +" / "+ (TOTALBUTTONPRESSES - 1) + " | " +"Time : " + ((endTime - startTime) / 1000) + "sec");
			currentTrial++;
			topTextStatus.setText("Press Button 1 to Start Trial " + currentTrial);
			Log.i(MYDEBUG, "Reset after trial" + topTextStatus.getText());
			getWindow().getDecorView().setBackgroundColor(Color.rgb(33, 150, 243));
		}
		else if(buttonCount == TOTALBUTTONPRESSES && currentTrial == 3){
			
			buttonCount = 0;
			testStart = false;
			Log.i(MYDEBUG, "Test End");
			endTime =  System.currentTimeMillis();
			
			moveButtons();
				
			//debugString = "Time Elapsed: ";
			debugStringStatus.setText("Mode: " + trialMode + " | " + "Trial: " + currentTrial + " | " + "Error : " + errorCount +" / "+ (TOTALBUTTONPRESSES - 1) + " | " +"Time : " + ((endTime - startTime) / 1000) + " sec");
			trialMode = 2;
			currentTrial = 1;
			topTextStatus.setText("Press button 1 to start part 2 ");
			Log.i(MYDEBUG, "Reset after trial" + topTextStatus.getText());
			getWindow().getDecorView().setBackgroundColor(Color.rgb(33, 150, 243));
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
		/*else if(buttonCount < TOTALBUTTONPRESSES && currentTrial == 2){
			Log.i(MYDEBUG, "Test TWOOoooooooo" + i);
			output = i + 1;
			nextButton = output;
			buttonCount++;		
			}
			*/
		
		
		return output;
	}
	
	public void moveButtons(){
		ImageButton imgBtn1 = buttonOne;
		ImageButton imgBtn2 = buttonTwo;
		ImageButton imgBtn3 = buttonThree;
		ImageButton imgBtn4 = buttonFour;
		ImageButton imgBtn5 = buttonFive;
		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imgBtn1.getLayoutParams();
		params.setMargins(240, 0, 0, 0); 
		imgBtn1.setLayoutParams(params);
		imgBtn2.setLayoutParams(params);
		imgBtn3.setLayoutParams(params);
		imgBtn4.setLayoutParams(params);
		imgBtn5.setLayoutParams(params);
	
		Log.i(MYDEBUG, "moveButtons");
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