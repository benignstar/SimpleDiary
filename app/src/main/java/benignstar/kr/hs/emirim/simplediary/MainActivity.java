package benignstar.kr.hs.emirim.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatePicker data;
    EditText edit;
    Button but;
    String file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=(DatePicker)findViewById(R.id.data);
        edit=(EditText)findViewById(R.id.edit);
        but=(Button)findViewById(R.id.but);


    }
}
