package in.codeworld.swipegesturedetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import in.codeworld.swipegesturedetection.interfaces.SwipeActions;

public class MainActivity extends AppCompatActivity {

    private View rootLayout;
    private TextView resultText;
    private SwipeGestureDetector swipeGestureDetector;
    private GestureDetectorCompat gestureDetectorCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout= findViewById(R.id.root_layout);
        resultText=findViewById(R.id.my_text_view);

        swipeGestureDetector=new SwipeGestureDetector(new SwipeActions() {
            @Override
            public void onSwipeLeft() {
              //  Toast.makeText(MainActivity.this, "Swiped Left", Toast.LENGTH_SHORT).show();
                resultText.setText("Swiped Left");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorLeft));
            }

            @Override
            public void onSwipeRight() {
               // Toast.makeText(MainActivity.this, "Swiped Right", Toast.LENGTH_SHORT).show();
                resultText.setText("Swiped Right");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorRight));
            }

            @Override
            public void onSwipeUp() {
               // Toast.makeText(MainActivity.this, "Swiped Up", Toast.LENGTH_SHORT).show();
                resultText.setText("Swiped Up");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorUp));

            }

            @Override
            public void onSwipeDown() {
               // Toast.makeText(MainActivity.this, "Swiped Down", Toast.LENGTH_SHORT).show();
                resultText.setText("Swiped Down");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorDown));
            }
        });


        gestureDetectorCompat = new GestureDetectorCompat(getApplicationContext(), swipeGestureDetector);

        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetectorCompat.onTouchEvent(event);
                return true;
            }
        });

    }


}
