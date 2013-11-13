package com.example.carrencycalculator;


import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main extends Activity {
	final String LOG_TAG = "myLogs";
	private static double EXCHANGE_RATE_USD;
	private static double EXCHANGE_RATE_EUR;
	private static double EXCHANGE_RATE_BYR;
	private static double EXCHANGE_RATE_RUB;
	private static double EXCHANGE_RATE_PLZ;
	
	RadioGroup radioG;
	ImageView flag;
	
	RadioButton rb_usd;
	RadioButton rb_eur;
	RadioButton rb_byr;
	RadioButton rb_rub;
	RadioButton rb_pol;
	
	Button fromUAH;
	Button toUAH;
	Button clear;
	
	EditText textUAH;
	EditText textCurrency;
	
	double uah;
	double ex_rate;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EXCHANGE_RATE_USD = 7.99;
		EXCHANGE_RATE_EUR = 9.78;
		EXCHANGE_RATE_BYR = 0.00086;
		EXCHANGE_RATE_RUB = 0.24;
		EXCHANGE_RATE_PLZ = 2.55;	
		
		ex_rate = EXCHANGE_RATE_USD;
		
		radioG = (RadioGroup) findViewById(R.id.radioGroup1);

		flag = (ImageView) findViewById(R.id.imageView2);
		
		rb_usd = (RadioButton) findViewById(R.id.rb_USD);
		rb_eur = (RadioButton) findViewById(R.id.rb_EUR);
		rb_byr = (RadioButton) findViewById(R.id.rb_BYR);
		rb_rub = (RadioButton) findViewById(R.id.rb_RUB);
		rb_pol = (RadioButton) findViewById(R.id.rb_PLN);
		rb_usd.setOnClickListener(new rbListener());
		rb_eur.setOnClickListener(new rbListener());
		rb_byr.setOnClickListener(new rbListener());
		rb_rub.setOnClickListener(new rbListener());
		rb_pol.setOnClickListener(new rbListener());
		//rb_usd.setChecked(true);
		
		fromUAH = (Button) findViewById(R.id.buttonFromTo);
		toUAH = (Button) findViewById(R.id.buttonToFrom);
		clear = (Button) findViewById(R.id.button_clear);
		
		textUAH = (EditText) findViewById(R.id.editTextCurrencyFrom);
		textCurrency = (EditText) findViewById(R.id.editTextCurrencyTo);
		
		fromUAH.setOnClickListener(new buttonListener());
		toUAH.setOnClickListener(new buttonListener());
		clear.setOnClickListener(new buttonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class rbListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			RadioButton rg = (RadioButton) v;
			switch (rg.getId()) {
			case R.id.rb_USD: flag.setImageResource(R.drawable.united_states_flag);	
			ex_rate = EXCHANGE_RATE_USD;
			break;
			case R.id.rb_EUR: flag.setImageResource(R.drawable.eu_flag);
			ex_rate = EXCHANGE_RATE_EUR;
			break;
			case R.id.rb_BYR: flag.setImageResource(R.drawable.belarus_flag);	
			ex_rate = EXCHANGE_RATE_BYR;
			break;
			case R.id.rb_RUB: flag.setImageResource(R.drawable.russia_flag);
			ex_rate = EXCHANGE_RATE_RUB;
			break;
			case R.id.rb_PLN: flag.setImageResource(R.drawable.poland_flag);
			ex_rate = EXCHANGE_RATE_PLZ;
			break;			
			default: 
			break;
			}
		}
		
	}
	
	private class buttonListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			Button b = (Button) v;
			double currency;
			switch (b.getId()) {
			case R.id.buttonFromTo: 			
				if (!TextUtils.isEmpty(textUAH.getText())){
					uah = Double.parseDouble(textUAH.getText().toString());
					currency = uah/ex_rate;
					textCurrency.setText(String.format("%.4f", currency)) ;				
				}
				else Toast.makeText(getApplicationContext(), "¬вед≥ть значенн€", Toast.LENGTH_SHORT).show();
				//Log.d(LOG_TAG, String.valueOf(result));
			break;
			case R.id.buttonToFrom: 

				if (!TextUtils.isEmpty(textCurrency.getText())) {
					currency = Double.parseDouble(textCurrency.getText().toString());
					uah = currency*ex_rate;
					textUAH.setText(String.format("%.4f", uah));
				}
				else Toast.makeText(getApplicationContext(), "¬вед≥ть значенн€", Toast.LENGTH_SHORT).show();
			break;
			case R.id.button_clear: 
				textUAH.setText("") ;	
				textCurrency.setText("");
			break;
			default: 
			break;
			}
		}
		
	}

}
