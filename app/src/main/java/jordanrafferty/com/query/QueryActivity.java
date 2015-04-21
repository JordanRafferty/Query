package jordanrafferty.com.query;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class QueryActivity extends Activity {

    public static final String TAG = QueryActivity.class.getSimpleName();

    private Query mQuery;
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        //Declare our View variables and assign them the Views from the layout file
        final TextView questionLabel = (TextView) findViewById(R.id.factTextView);
        final Button showQueryButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        mQuery = new Query(this.getResources().getStringArray(R.array.questions_array));
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fact = mQuery.getQuestion();
                //Update the label with our dynamic fact
                questionLabel.setText(fact);


                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showQueryButton.setTextColor(color);
            }
        };
        showQueryButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We're logging from the onCreate() method!");

    }

}
