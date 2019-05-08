package driver.bus.dibu.demoview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * https://blog.csdn.net/qq_24675479/article/details/81411996      android进阶——自定义View
 *
 * https://blog.csdn.net/lj19851227/article/details/82689467     Android高级进阶之自定义View(改activity)
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private CircleProgress mCircleProgress;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mCircleProgress = findViewById(R.id.cp_progress);
        mCircleProgress.setPercentage(40);
        mCircleProgress.setTitleText("运动消耗");
        mCircleProgress.setValue(60);
        mCircleProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCircleProgress.startCircleProgressAnim();
                mCircleProgress.startValueAnim();
            }
        });
    }
}
