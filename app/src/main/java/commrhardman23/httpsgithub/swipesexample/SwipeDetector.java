package commrhardman23.httpsgithub.swipesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SwipeDetector extends AppCompatActivity implements GestureDetector.OnGestureListener {

    static final int PICK_CONTACT_REQUEST = 0;

    private GestureDetector motionDetector;
    private TextView txtvwMotionDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_detector);

        txtvwMotionDisplay = (TextView) findViewById(R.id.txtvwMotionDisplay);

        motionDetector = new GestureDetector(this,this);
    }

    public boolean onTouchEvent(MotionEvent event){

        this.motionDetector.onTouchEvent(event);

        return super.onTouchEvent(event);

    }

    @Override
    public boolean onDown(MotionEvent event) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {

        return false;

    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {

        return false;

    }

    @Override
    public void onLongPress(MotionEvent event) {

    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

        if(velocityX > 0){
            txtvwMotionDisplay.setText("You just swiped the wrong direction");
        } else {
            Intent displayMessage = new Intent(this, DisplayNewScreen.class);
            startActivityForResult(displayMessage, 0);
        }

        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        txtvwMotionDisplay.setText(data.getStringExtra("RETURN_MESSAGE"));

    }
}
