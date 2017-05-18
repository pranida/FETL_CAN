package fetl.praniday.fetl_can;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView backImageView, imageView;
    private TextView titleTextView, detailTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initial View
        initialView();

        //Show View
        showView();


    }   // Main Method

    private void showView() {

        String strTitle = getIntent().getStringExtra("Name");
        String strDetail = getIntent().getStringExtra("Detail");
        String strIcon = getIntent().getStringExtra("Icon");

        titleTextView.setText("By : " + strTitle);
        detailTextView.setText(strDetail);
        Picasso.with(DetailActivity.this).load(strIcon).into(imageView);

    }

    private void initialView() {
        backImageView = (ImageView) findViewById(R.id.imvBack);
        imageView = (ImageView) findViewById(R.id.imvImage);
        titleTextView = (TextView) findViewById(R.id.txtTitle);
        detailTextView = (TextView) findViewById(R.id.txtDetail);
    }

}   // Main Class