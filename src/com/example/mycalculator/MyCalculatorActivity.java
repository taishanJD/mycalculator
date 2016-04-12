package com.example.mycalculator;

import com.example.mycalculator.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyCalculatorActivity extends Activity {

	 TextView tv;
	 Button buttonadd, buttonsub, buttonmul, buttondiv, buttonequal,buttonC, temp;
	 int[] buttons;
	 float result, result0, result1;
	 int flag;

	 String str, str2, str1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initButton();
		
		buttonC.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				str1 = "";
				str2 = "";
				tv.setText(str1);
				flag = 0;
			}
		});//为buttonC设置事件监听器，点击后清屏。
		
		for(int i=0; i<buttons.length;i++)
		{
			temp = (Button)findViewById(buttons[i]);
			temp.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					str1 = tv.getText().toString().trim();
					str1 = str1+String.valueOf(((Button)v).getText());
					tv.setText(str1);
				}
			});
		}//为0~9数字键设置事件监听器，点击使其显示。
		
		buttonListener(buttonadd, 1);
		buttonListener(buttonsub, 2);
		buttonListener(buttonmul, 3);
		buttonListener(buttondiv, 4);
		
		buttonequal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				result1 = Float.parseFloat(str1);
				if(flag == 1)
					result = (float) (result1+result0);
				else if(flag==2)
					result = (float) (result0 - result1);
				else if(flag==3)
					result = (float) (result1 * result0);
				else if(flag==4)
					result =(float) (result0 / result1);
				str = (result+"").trim();
				tv.setText(str);
				
			}
		});
	}

	public void initButton() {
		tv = (TextView) findViewById(R.id.tv);

		buttonadd = (Button) findViewById(R.id.Button_add);
		buttonsub = (Button) findViewById(R.id.Button_sub);
		buttonmul = (Button) findViewById(R.id.Button_mul);
		buttondiv = (Button) findViewById(R.id.Button_div);
		buttonequal = (Button) findViewById(R.id.Button_equal);
		buttonC = (Button) findViewById(R.id.Button_C);

		buttons = new int[] { R.id.Button_00, R.id.Button_01, R.id.Button_02,
				R.id.Button_03, R.id.Button_04, R.id.Button_05, R.id.Button_06,
				R.id.Button_07, R.id.Button_08, R.id.Button_09 };		
	}
	
	public void  buttonListener(Button button,final int id) {
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				str = tv.getText().toString().trim();
				result0 = Float.parseFloat(str);
				tv.setText("");
				flag = id;
			}
		});
	}

}
