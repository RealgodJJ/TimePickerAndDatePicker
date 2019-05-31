package realgodjj.example.com.timepickeranddatepicker;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String REALGOD_JJ = "RealgodJJ";
    private TimePicker tpShowTime;
    private DatePicker dpShowDate;
    private TextView tvShow;
    private int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDate();
        setPicker();
    }

    private void setPicker() {
        tpShowTime.setIs24HourView(true);
        tpShowTime.setHour(hour);
        tpShowTime.setMinute(minute);
    }

    private void initDate() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        dpShowDate.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.v(REALGOD_JJ, "From TimePicker: " + year + "/" + monthOfYear + "/" + dayOfMonth);
                tvShow.setText(String.valueOf(year) + "/" + String.valueOf(monthOfYear + 1) + "/" +
                        String.valueOf(dayOfMonth));
            }
        });
    }

    private void initView() {
        tpShowTime = findViewById(R.id.tp_show_time);
        dpShowDate = findViewById(R.id.dp_show_date);
        tvShow = findViewById(R.id.tv_show);

        tpShowTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Log.d(REALGOD_JJ, "From TimePicker: " + hourOfDay + ":" + minute);
                tvShow.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
            }
        });

        dpShowDate.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.d(REALGOD_JJ, "From TimePicker: " + year + "/" + monthOfYear + "/" + dayOfMonth);
                tvShow.setText(String.valueOf(year) + "/" + String.valueOf(monthOfYear + 1) + "/" +
                        String.valueOf(dayOfMonth));
            }
        });
    }
}
