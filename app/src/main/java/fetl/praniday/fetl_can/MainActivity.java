package fetl.praniday.fetl_can;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString , passwordString;

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

            //Get Value from Editext
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //check Space

            if (userString .equals("")  || passwordString.equals("") ) {

                //Have Space
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.message_HaveSpace));

            } else {
                //No Space
                checkUserAnPass();

            }


        }

    }

    private void checkUserAnPass() {
        try {

            GetData getData = new GetData(this);
            MyConstant myConstant = new MyConstant();
            getData.execute(myConstant.getUrlGetUser());
            String strJSON = getData.get();
            Log.d("17MayV2" , "JSON ==> " + strJSON);

            //<<if no log then open
            //showMessage(strJSON);
            //>>if no log then open



            //<<cut , log
            JSONArray jsonArray = new JSONArray(strJSON);
            boolean b = true; //user false
            String strName = null, strPassword = null;
            MyAlert myAlert = new MyAlert(this);


            for (int i = 0 ; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString("User"))) {

                    b = false;
                    strName = jsonObject.getString("Name");
                    strPassword = jsonObject.getString("Password");
                }
            }//for  >>cut , log


            if (b) {
                //user false
                myAlert.myDialog(getResources().getString(R.string.title_UserFalse),
                        getResources().getString(R.string.message_UserFalse));
            } else if (passwordString.equals(strPassword )) {
                //password True
                Toast.makeText(MainActivity.this, "Welcome " + strName, Toast.LENGTH_SHORT).show();

                //Intent to service
                Intent intent = new Intent(MainActivity.this,ServiceActivity.class);
                intent.putExtra("Login" , strName);
                startActivity(intent);
                finish();


            } else {
                //password false
                myAlert.myDialog(getResources().getString(R.string.title_passwordFalse),
                        getResources().getString(R.string.message_passwordFalse));
            }



        } catch (Exception e) {
            Log.d("17MayV2" , "e checkuser ==> " + e.toString());

        }
    }

    //<<if no log then open
//private void showMessage(String strJSON) {
    //Toast.makeText(MainActivity.this,strJSON,Toast.LENGTH_SHORT).show();
    //}
//>>if no log then open





}//Main class
