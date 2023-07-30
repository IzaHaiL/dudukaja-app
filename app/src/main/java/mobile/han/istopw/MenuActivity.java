package mobile.han.istopw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void reminder(View view) {
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);
    }

    public void watch(View view) {
        Intent intent = new Intent(this, WatchActivity.class);
        startActivity(intent);

    }

    public void tips(View view) {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);

    }
}