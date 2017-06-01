package benignstar.kr.hs.emirim.simplediary;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs=openFileOutput(file_name, Context.MODE_PRIVATE);
                    String str=edit.getText().toString();
                    outFs.write(str.getBytes());
                    Toast.makeText(getApplicationContext(), file_name+"이 저장됨",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

    }
    public String readDiary(String file_name){
        String diaryStr=null;
        FileInputStream inFs;
        try{
            inFs=openFileInput(file_name);
            byte[] txt=new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr=(new String(txt)).trim();
            but.setText("수정");
        }catch (IOException e){
            edit.setHint("일기 없음");
            but.setText("새로 저장");
        }
        return diaryStr;
    }
}
