package com.example.practical1customstyle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtNumber;
    RadioButton radioV, radioNV, RadioBut,r1,r2;
    CheckBox checkP, checkB, checkS;
    Button butOrder;
    RadioGroup radioG;
    TextView OrderDetails2, OrderDetails;

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText)findViewById(R.id.edtName);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        r1=(RadioButton)findViewById(R.id.r1) ;
        r2=(RadioButton)findViewById(R.id.radioNVv);

        radioV = (RadioButton)findViewById(R.id.radioV);
        radioNV = (RadioButton)findViewById(R.id.radioNV);
        radioG = (RadioGroup)findViewById(R.id.radioG);

        checkP = (CheckBox)findViewById(R.id.checkP);
        checkB = (CheckBox)findViewById(R.id.checkB);
        checkS = (CheckBox)findViewById(R.id.checkS);
        butOrder = (Button)findViewById(R.id.butOrder);
        butOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == butOrder){

            int SelectedID = radioG.getCheckedRadioButtonId();
            RadioBut = (RadioButton)findViewById(SelectedID);
            String R = RadioBut.getText().toString();

            if (R.equals("Veg")){

                if (checkP.isChecked()){
                    total = total + 100;
                }

                if (checkB.isChecked()){
                    total = total + 100;
                }

                if (checkS.isChecked()){
                    total = total + 50;
                }

            }

            if (R.equals("Non-Veg")){

                if (checkP.isChecked()){
                    total = total + 200;
                }

                if (checkB.isChecked()){
                    total = total + 150;
                }

                if (checkS.isChecked()){
                    total = total + 100;
                }

            }
            if (R.equals("Jain")){

                if (checkP.isChecked()){
                    total = total + 200;
                }

                if (checkB.isChecked()){
                    total = total + 150;
                }

                if (checkS.isChecked()){
                    total = total + 100;
                }

            }
            if (R.equals("Non-Jain")){

                if (checkP.isChecked()){
                    total = total + 200;
                }

                if (checkB.isChecked()){
                    total = total + 150;
                }

                if (checkS.isChecked()){
                    total = total + 100;
                }

            }

            String Summary = "Name: " +edtName.getText()+ "\nPhone: "+edtNumber.getText()+"\nType: "+RadioBut.getText().toString()+"\nTotal: "+total;
            total = 0;

            Toast.makeText(this,Summary, Toast.LENGTH_LONG).show();
//            checkP.setChecked(false);
//            checkB.setChecked(false);
//            checkS.setChecked(false);

        }

    }
}
