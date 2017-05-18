package fetl.praniday.fetl_can;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 5/18/2017 AD.
 */

public class SearchKey extends AsyncTask<String, Void, String>{

    private Context context;

    public SearchKey(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            MyConstant myConstant = new MyConstant();
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Keycode", strings[0])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(myConstant.getUrlGetProduceWhereCode())
                    .post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}   // Main Class