package com.myapp1.amrutha.yourCalcu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double num1,num2,sum,sub,div,mul;
    Button a,s,d,m;
    EditText e,ed;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=(TextView)findViewById(R.id.textview3);
        a=(Button)findViewById(R.id.button1);
        s=(Button)findViewById(R.id.button2);
        d=(Button)findViewById(R.id.button3);
        m=(Button)findViewById(R.id.button4);
        e=(EditText)findViewById(R.id.edittext1);
        ed=(EditText)findViewById(R.id.edittext2);
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                num1 = Double.parseDouble(e.getText().toString());
                num2 = Double.parseDouble(ed.getText().toString());
                sum = num1 + num2;
                result.setText(Double.toString(sum));
            }
        });
        s.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                num1 = Double.parseDouble(e.getText().toString());
                num2 = Double.parseDouble(ed.getText().toString());
                sub = num1 - num2;
                result.setText(Double.toString(sub));
            }
        });
        d.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view)
            {
                num1 = Double.parseDouble(e.getText().toString());
                num2 = Double.parseDouble(ed.getText().toString());
                div = num1 /num2;
                result.setText(Double.toString(div));
            }
        });
        m.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                num1 = Double.parseDouble(e.getText().toString());
                num2 = Double.parseDouble(ed.getText().toString());
                mul = num1 * num2;
                result.setText(Double.toString(mul));
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
