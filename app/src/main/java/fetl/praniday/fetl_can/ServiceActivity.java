package fetl.praniday.fetl_can;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {
//Explicit
    private TextView textView;
    private ImageView barImageView ,qrImageView;
    private ListView listView ;
    private  String nameString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Initial View

        initialView();


        //Show Text
        showText();

        //Create listview
        createListView();


    }//main Method

    private void createListView() {

        try {

            MyConstant myConstant = new MyConstant();
            String urlJSON = myConstant.getUrlGetProduct();

            GetData getData = new GetData(this);
            getData.execute(urlJSON);
            String strJSON = getData.get();
            Log.d("18MayV1" , "JSON ==> " + strJSON);

        } catch (Exception e) {

            Log.d("18MayV1" , "e createListview ==> " + e.toString());
        }
    }

    private void showText() {
        nameString = getIntent().getStringExtra("Login");
        textView.setText("Login by : " + nameString);
    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtNameLogin);
        barImageView = (ImageView) findViewById(R.id.imvBarcode);
        qrImageView = (ImageView) findViewById(R.id.imvQrCode);
        listView = (ListView) findViewById(R.id.LivProduct);
    }



}//main class
