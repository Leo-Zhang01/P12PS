package sg.edu.rp.c346.p12ps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class AboutUs extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        imageView = findViewById(R.id.imageView);

        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.get().load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(imageView);

    }
}
