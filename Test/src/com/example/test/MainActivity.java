package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText input; //text
	Button b1; //show button
	Button b2; //clear button
	Button b3; //Click me button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        input = (EditText) findViewById(R.id.editText1);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        
        b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) 
			{
				if(v==b1)
				{
					input.setText("hey...");
				}
			}
			
			
		});
        
        b2.setOnClickListener(new View.OnClickListener() 
        {

			@Override
			public void onClick(View v) {
				
				
				if(v==b2)
				{
					input.setText("");
				}
				
		}
			
		});
        
        b3.setOnClickListener(new View.OnClickListener() 
        {

			@Override
			public void onClick(View v) {
				
				
				if(v==b3)
				{
					Context context  = getApplicationContext();
					CharSequence text="hey...wassss up??";
					int duration=Toast.LENGTH_LONG;
					final Toast tost=Toast.makeText(context, text, duration);
					tost.show();
				}
		}
			
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
