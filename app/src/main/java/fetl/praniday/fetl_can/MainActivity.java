package fetl.praniday.fetl_can;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial View
        initialView();

        //Controller
        controller();


    }// Main Method


    private  void  controller() {
        textView.setOnClickListener(MainActivity.this); //กด Alt+enter
        button.setOnClickListener(MainActivity.this);
    }
    private  void  initialView() {
        userEditText = (EditText)  findViewById(R.id.edtUser);  //(EditText) from Alt+enter แคส
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewRegister);
        button = (Button) findViewById(R.id.btnLogin);
    }


    @Override
    public void onClick(View v) {  //View v come java vertion

        //for textview
        if (v == textView) {
            //intent to Register
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
        //for button
        if (v == button){

        }

    }
}//Main class
