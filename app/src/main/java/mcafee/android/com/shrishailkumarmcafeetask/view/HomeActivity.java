package mcafee.android.com.shrishailkumarmcafeetask.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mcafee.android.com.shrishailkumarmcafeetask.R;
import mcafee.android.com.shrishailkumarmcafeetask.model.ThreadSafeSingelton;
import mcafee.android.com.shrishailkumarmcafeetask.presenter.HomePresenter;

public class HomeActivity extends Activity implements HomePresenter.HomeVieDelegate {

    HomePresenter mHompresenter;
    Button mButton;
    EditText mCounterInput;
    TextView mTextVieewShowCounter;
    final Handler handler = new Handler();
    Timer timer;
    TimerTask mTimerTask;
    int[] counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mHompresenter = new HomePresenter(this);

        mButton = findViewById(R.id.button_start);
        mCounterInput = findViewById(R.id.editText_input);
        mTextVieewShowCounter = findViewById(R.id.textView_timer_display);

        mButton.setOnClickListener(view -> mHompresenter.onClickOfStart());

        //TODO uncoment this to Enable Answer for Singleton class which is non clonable.
        /*try {
            mHompresenter.createClonableTaskOb();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        mHompresenter.onClickOfStart();
        outState.putInt("counter_value", counter[0]);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (null==counter) {
            counter = new int[]{0};
        }
        counter[0] = savedInstanceState.getInt("counter_value");
    }

    @Override
    public void onClickofStartButton() {
        counter = new int[]{Integer.parseInt(mCounterInput.getText().toString())};
        if (null!=counter) {
            new CountDownTimer(counter[0] * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTextVieewShowCounter.setText(String.valueOf(counter[0]));
                    counter[0]--;
                    mButton.setVisibility(View.GONE);

                }

                @Override
                public void onFinish() {
                    mTextVieewShowCounter.setText("Completed");
                    mButton.setVisibility(View.VISIBLE);
                }
            }.start();
        }
        //second way -->
        /*timer = new Timer();

        //initialize the TimerTask's job
        mTimerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {
                        mTextVieewShowCounter.setText(String.valueOf(counter[0]));
                        counter[0]--;
                        mButton.setVisibility(View.GONE);
                        if (counter[0]==0){
                            mTextVieewShowCounter.setText("Completed");
                            mButton.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        };

        //schedule the timer, after the first x ms the TimerTask will run every 10000ms
        timer.schedule(mTimerTask, 10, counter[0]*1000); //
*/


    }


}
