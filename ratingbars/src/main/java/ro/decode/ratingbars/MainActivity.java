package ro.decode.ratingbars;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private RatingBar resultRating;
    private TextView rating;
    private TextView nrRecenziiText;
    private int nrRecenzii = 0;
    private int sumaRecenzii = 0;
    private int[] nrRecenziiStea = {0, 0, 0, 0, 0, 0};
    private RatingBars ratingBars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ratingBars = (RatingBars) findViewById(R.id.surface);
        ratingBars.setStars(nrRecenziiStea);
        ratingBars.setNrRecenzii(nrRecenzii);
        ratingBars.setDistanceBetweenBars(50);
        ratingBars.invalidate();




        ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
        resultRating = (RatingBar) findViewById(R.id.ratingBar);
        rating = (TextView) findViewById(R.id.rating);
        nrRecenziiText = (TextView) findViewById(R.id.nrRecenzii);




    }

    @Override
    public void onResume(){

        super.onResume();


    }
    public void rateButton(View view) {
        nrRecenzii++;
        sumaRecenzii += ratingBar.getRating();
        nrRecenziiStea[(int) ratingBar.getRating()]++;


        DecimalFormat df = new DecimalFormat("#.#");
        float rezultat = (float) sumaRecenzii / nrRecenzii;
        resultRating.setRating(rezultat);
        rating.setText(df.format((double) sumaRecenzii / nrRecenzii));
        nrRecenziiText.setText(String.valueOf(nrRecenzii));


        ratingBars.setStars(nrRecenziiStea);
        ratingBars.setNrRecenzii(nrRecenzii);
        ratingBars.invalidate();


    }

}