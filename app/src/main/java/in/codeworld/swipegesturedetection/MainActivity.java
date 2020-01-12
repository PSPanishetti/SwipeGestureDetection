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

        //Assign the swipeGestureDetector by creating new instance

        swipeGestureDetector=new SwipeGestureDetector(new SwipeActions() {
            @Override
            public void onSwipeLeft() {
                //Write The actions need to be performed when Swiped Left here
                resultText.setText("Swiped Left");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorLeft));
            }

            @Override
            public void onSwipeRight() {
                //Write The actions need to be performed when Swiped Right here
                resultText.setText("Swiped Right");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorRight));
            }

            @Override
            public void onSwipeUp() {
                //Write The actions need to be performed when Swiped up here
                resultText.setText("Swiped Up");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorUp));

            }

            @Override
            public void onSwipeDown() {
                //Write The actions need to be performed when Swiped down here
                resultText.setText("Swiped Down");
                rootLayout.setBackgroundColor(getResources().getColor(R.color.colorDown));
            }
        });


        //Assign GestureDetectorCompat instance by passing swipeGestureDetector instance
        gestureDetectorCompat = new GestureDetectorCompat(getApplicationContext(), swipeGestureDetector);

        //Set onTouchListener on rootLayout
        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetectorCompat.onTouchEvent(event);
                //Make sure it returns true because event needs to be consumed in the end
                return true;
            }
        });

    }


}
