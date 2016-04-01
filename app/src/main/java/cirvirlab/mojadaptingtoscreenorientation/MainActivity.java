package cirvirlab.mojadaptingtoscreenorientation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    public void openMap(View view){
        ImageButton imageButton = (ImageButton)view;
        startActivity(new Intent(getApplicationContext(),MapsActivity.class));
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openWriteComment(View view) {
        ImageButton imageButton = (ImageButton)view;
        startActivity(new Intent(getApplicationContext(),Dopisivanje.class));
    }

    public void openSummary(View view) {
        ImageButton imageButton =(ImageButton)view;
        startActivity(new Intent(getApplicationContext(),Summary.class));
    }
}
