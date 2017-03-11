package com.myapp.amrutha.facebook;

import android.content.DialogInterface;
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
   Button login,create;
    EditText user,pass;
    String UN,PD;
    TextView err,suc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.log);
        create=(Button)findViewById(R.id.create);
        user=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText1);
        err=(TextView)findViewById(R.id.text);
        suc=(TextView)findViewById(R.id.text1);
        login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                UN=user.getText().toString();
                PD=pass.getText().toString();
                if(UN!="amruthamunic@gmail.com"&&PD!="qwerty123")
                {
                 err.setVisibility(View.VISIBLE);
                }
                else if(PD=="qwerty123"&&UN!="amruthamunic@gmail.com")
                {
                    suc.setVisibility(View.VISIBLE);
                }
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
