package ro.decode.ratingbars;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class RatingBars extends SurfaceView implements SurfaceHolder.Callback{

    private int stars[] = new int[6];
    private int nrRecenzii = 0;
    private  int distanceBetweenBars;
    private boolean surfaceIsCreated=false;

    private Paint stars5;
    private Paint stars4;
    private Paint stars3;
    private Paint stars2;
    private Paint stars1;
    private Paint black;

    public void setNrRecenzii(int nrRecenzii) {
        this.nrRecenzii = nrRecenzii;
    }

    public void setStars(int[] stars) {
        this.stars = stars;
    }
    public void setDistanceBetweenBars(int distanceBetweenBars) {
        this.distanceBetweenBars = distanceBetweenBars;
    }

    public RatingBars(Context context) {
        super(context);

    }

    public RatingBars(Context context, AttributeSet attributeSet){

        super(context, attributeSet);
        stars5=new Paint();
        stars4=new Paint();
        stars3=new Paint();
        stars2=new Paint();
        stars1=new Paint();

        stars5.setColor(getResources().getColor(R.color.green));
        stars4.setColor(getResources().getColor(R.color.green1));
        stars3.setColor(getResources().getColor(R.color.yelow));
        stars2.setColor(getResources().getColor(R.color.orange));
        stars1.setColor(getResources().getColor(R.color.orange1));

        black=new Paint();
        black.setColor(Color.BLACK);
        black.setTextSize(50f);

        this.setWillNotDraw(false);
        this.getHolder().addCallback(this);

        this.setZOrderOnTop(true);    // necessary
        SurfaceHolder sfhTrackHolder = this.getHolder();
        sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Canvas canvas = holder.lockCanvas();
        holder.unlockCanvasAndPost(canvas);
    }



    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(nrRecenzii==0){
            canvas.drawRect(20, (1 * distanceBetweenBars + 0 * (getHeight() - 6 * distanceBetweenBars) / 5), 30, 1 * distanceBetweenBars + 1 * (getHeight() - 6 * distanceBetweenBars) / 5, stars5);
            canvas.drawRect(20, (2 * distanceBetweenBars + 1 * (getHeight() - 6 * distanceBetweenBars) / 5), 30, 2 * distanceBetweenBars + 2 * (getHeight() - 6 * distanceBetweenBars) / 5, stars4);
            canvas.drawRect(20, (3 * distanceBetweenBars + 2 * (getHeight() - 6 * distanceBetweenBars) / 5), 30, 3 * distanceBetweenBars + 3 * (getHeight() - 6 * distanceBetweenBars) / 5, stars3);
            canvas.drawRect(20, (4 * distanceBetweenBars + 3 * (getHeight() - 6 * distanceBetweenBars) / 5), 30, 4 * distanceBetweenBars + 4 * (getHeight() - 6 * distanceBetweenBars) / 5, stars2);
            canvas.drawRect(20, (5 * distanceBetweenBars + 4 * (getHeight() - 6 * distanceBetweenBars) / 5), 30, 5 * distanceBetweenBars + 5 * (getHeight() - 6 * distanceBetweenBars) / 5, stars1);

            canvas.drawText(String.valueOf(stars[5]), 40, 1 * distanceBetweenBars + 1 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[4]), 40, 2 * distanceBetweenBars + 2 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[3]), 40, 3 * distanceBetweenBars + 3 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[2]), 40, 4 * distanceBetweenBars + 4 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[1]), 40, 5 * distanceBetweenBars + 5 * (getHeight() - 6 * distanceBetweenBars) / 5, black);

        }else {
            canvas.drawRect(20, (1 * distanceBetweenBars + 0 * (getHeight() - 6 * distanceBetweenBars) / 5), 30 + (float) (0.75 * getWidth() * stars[5] / nrRecenzii), 1 * distanceBetweenBars + 1 * (getHeight() - 6 * distanceBetweenBars) / 5, stars5);
            canvas.drawRect(20, (2 * distanceBetweenBars + 1 * (getHeight() - 6 * distanceBetweenBars) / 5), 30 + (float) (0.75 * getWidth() * stars[4] / nrRecenzii), 2 * distanceBetweenBars + 2 * (getHeight() - 6 * distanceBetweenBars) / 5, stars4);
            canvas.drawRect(20, (3 * distanceBetweenBars + 2 * (getHeight() - 6 * distanceBetweenBars) / 5), 30 + (float) (0.75 * getWidth() * stars[3] / nrRecenzii), 3 * distanceBetweenBars + 3 * (getHeight() - 6 * distanceBetweenBars) / 5, stars3);
            canvas.drawRect(20, (4 * distanceBetweenBars + 3 * (getHeight() - 6 * distanceBetweenBars) / 5), 30 + (float) (0.75 * getWidth() * stars[2] / nrRecenzii), 4 * distanceBetweenBars + 4 * (getHeight() - 6 * distanceBetweenBars) / 5, stars2);
            canvas.drawRect(20, (5 * distanceBetweenBars + 4 * (getHeight() - 6 * distanceBetweenBars) / 5), 30 + (float) (0.75 * getWidth() * stars[1] / nrRecenzii), 5 * distanceBetweenBars + 5 * (getHeight() - 6 * distanceBetweenBars) / 5, stars1);

            canvas.drawText(String.valueOf(stars[5]), 40 + (float) (0.75 * getWidth() * stars[5] / nrRecenzii), 1 * distanceBetweenBars + 1 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[4]), 40 + (float) (0.75 * getWidth() * stars[4] / nrRecenzii), 2 * distanceBetweenBars + 2 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[3]), 40 + (float) (0.75 * getWidth() * stars[3] / nrRecenzii), 3 * distanceBetweenBars + 3 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[2]), 40 + (float) (0.75 * getWidth() * stars[2] / nrRecenzii), 4 * distanceBetweenBars + 4 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
            canvas.drawText(String.valueOf(stars[1]), 40 + (float) (0.75 * getWidth() * stars[1] / nrRecenzii), 5 * distanceBetweenBars + 5 * (getHeight() - 6 * distanceBetweenBars) / 5, black);
        }

    }
}
