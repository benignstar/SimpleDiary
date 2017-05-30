package benignstar.kr.hs.emirim.simplediary;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    EditText edit;
    Button but;
    String file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date=(DatePicker)findViewById(R.id.date);
        edit=(EditText)findViewById(R.id.edit);
        but=(Button)findViewById(R.id.but);

        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DATE);

        date.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                file_name=Integer.toString(i)+"_"+Integer.toString(i1+1)+"_"+Integer.toString(i2)+".txt";
                String readData=readDiary(file_name);
                edit.setText(readData);
                but.setEnabled(true);
            }
        });


    }
    public String readDiary(String file_name){

        return null;
    }
}
