package com.myapp.amrutha.facebook;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final sqlitehelper mydb = new sqlitehelper(MainActivity.this, null, this, 2);
        Button login, create;
        final EditText user,pass;
        final TextView err;
        login = (Button) findViewById(R.id.log);
        create = (Button) findViewById(R.id.create);
        user = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.password);
        err = (TextView) findViewById(R.id.text);
        create.setOnClickListener(new View.OnClickListener()
        {

            @Override
                   public void onClick(View view) {
                         if (user.getText().toString().equals("")&&pass.getText().toString().equals(""))
                              {
                                  Cursor c= mydb.getAllData();
                              if(c.getCount()==0)
                                  {
                                               ShowAllData("Error", "No Data in Database");
                                   return;
                               }
                               StringBuffer sb=new StringBuffer();
                                while (c.moveToNext())
                                   {
                                 sb.append("email:"+c.getString(0)+"\n");
                                  sb.append("pass:"+c.getString(1)+"\n");
                             }
                              ShowAllData("Success", sb.toString());
                            }
                          else{
                                  boolean inserted=mydb.insertdetails(user.getText().toString(), pass.getText().toString());
                                   if(inserted=true)
                                       {
                                               Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_SHORT).show();
                                   }
                              }

                               }
              });
            login.setOnClickListener(new View.OnClickListener() {
                       @Override
                    public void onClick(View view) {
                              String emailid=user.getText().toString();
                              String password=pass.getText().toString();
                              System.out.println(emailid);
                              String dbpass =mydb.authenticationUser(emailid);
                              System.out.println(dbpass);
                              if ( dbpass.equals("")) {
                                  String y = "The  Email you entered is Not exist Enter correct email OR Please create New Account";
                                  err.setText(y);
                                  err.setVisibility(View.VISIBLE);
                                 }
                                else if ( dbpass.equals(password))
                                    {

                                        Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(MainActivity.this, Homepage.class);
                                        startActivity(i);
                                    }
                              else

                              {
                                  String n = "The password you entered is incorrect.Did you forget your password";
                                  err.setText(n);
                                  err.setVisibility(View.VISIBLE);
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    public  void ShowAllData(String title, String message) {
        AlertDialog.Builder alertmsg = new AlertDialog.Builder(this);
        alertmsg.setCancelable(true);
        alertmsg.setTitle(title);
        alertmsg.setMessage(message);
        alertmsg.show();

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.myapp.amrutha.facebook/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.myapp.amrutha.facebook/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
