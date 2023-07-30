package mobile.han.istopw;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Vibrator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderActivity extends AppCompatActivity{
    Button myButton, myButton2;
    MediaPlayer mP;
    ImageView muter_IV;
    private Spinner spinner1;
    private int seconds;
    private  boolean running;
    private int waktu = 0;
    private Object TextView;

    ArrayAdapter adapter;

    // boolean click = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        myButton2 = findViewById(R.id.stop);
        mP = MediaPlayer.create(this, R.raw.beep);

        myButton = findViewById(R.id.start);
        mP = MediaPlayer.create(this, R.raw.beep);

        spinner1 = (Spinner) findViewById(R.id.spinnert);
        spinner1.setOnItemSelectedListener(new ItemSelectedListener());

        String text = spinner1.getSelectedItem().toString();
        
        TextView = findViewById(R.id.textView);


        muter_IV=findViewById(R.id.muter_iv);






        //myButton.se tEnabled(click);

        myButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                myButton.setEnabled(false);
                myButton2.setEnabled(false);
                spinner1.setEnabled(false);
                RotateAnimation rotateAnimation=new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, .5f,
                        RotateAnimation.RELATIVE_TO_SELF,.5f);
                rotateAnimation.setDuration(waktu);
                muter_IV.startAnimation(rotateAnimation);
                myButton.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(10000, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            //deprecated in API 26
                            v.vibrate(500);
                        }
                        Toast.makeText(ReminderActivity.this, "Ayo jangan Duduk Terus"  ,Toast.LENGTH_SHORT).show();
                        mP.start();
                        for (int i = 1; i <= 3; i++) {
                            mP.setLooping(true);
                            i++;
                        }
                        myButton2.setEnabled(true);
                        spinner1.setEnabled(false);

                    }
                },waktu);

            }

        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mP.pause();
                myButton.setEnabled(true);
                spinner1.setEnabled(true);




                }
        });
    }

    private class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner1.getSelectedItem());

        @SuppressLint("SetTextI18n")
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {

               // click = false;
                myButton.setEnabled(false);



              //    Toast.makeText(ReminderActivity.this, "" + click, Toast.LENGTH_SHORT).show();

            } else {
                String item = adapterView.getItemAtPosition(i).toString();
                Integer time = Integer.parseInt(item);
                Integer subTime = time * 1000;
                waktu = subTime;

                // click = true;
                myButton.setEnabled(true);
                TextView timeView = findViewById(R.id.textView);
                timeView.setText(getString(R.string.Akan) + item +getString(R.string.dalam));

                Toast.makeText(ReminderActivity.this, item, Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    }
}





