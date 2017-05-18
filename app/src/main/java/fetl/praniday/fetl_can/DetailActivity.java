package fetl.praniday.fetl_can;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView backImageView,imageView;
    private TextView titleTextview, detailTextview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Intial view
        intialView();

        //show view
        showView();


    }

    private void showView() {

        String strTitle = getIntent().getStringExtra("Name" );
        String strDetail = getIntent().getStringExtra("Detail");
        String strIcon = getIntent().getStringExtra("Icon");

        titleTextview.setText(strTitle);
        detailTextview.setText(strDetail);
        Picasso.with(DetailActivity.this).load(strIcon).into(imageView);

    }

    private void intialView() {
        backImageView = (ImageView) findViewById(R.id.imvBack);
        imageView = (ImageView) findViewById(R.id.imvImage);
        titleTextview = (TextView) findViewById(R.id.txtTitle);
        detailTextview = (TextView) findViewById(R.id.txtDetail);
    }



}//main cladd
