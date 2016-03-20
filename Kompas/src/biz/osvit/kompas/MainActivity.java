package biz.osvit.kompas;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    // definiranje slike za kompas
    private ImageView image;

    // postavljanje poèetnog kuta
    private float currentDegree = 0f;

    // pozivanje senzor managera
    private SensorManager mSensorManager;

    TextView tvHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // slika za kompas u png formatu
        image = (ImageView) findViewById(R.id.imageViewCompass);

        // TextView za kut
        tvHeading = (TextView) findViewById(R.id.tvHeading);

        // inicijaliziranje senzora na android ureðaju
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // uzjebani za senzor rotacije
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // zaustavljamo uzjebane radi uštede baterije
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // dobivamo kut oko osi rotacije
        float degree = Math.round(event.values[0]);

        tvHeading.setText("Heading: " + Float.toString(degree) + " degrees");

        // kreiramo rotaciju za animiranje
        RotateAnimation ra = new RotateAnimation(
                currentDegree, 
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f, 
                Animation.RELATIVE_TO_SELF,
                0.5f);

        // koliko dugo animacija zauzima mjesto
        ra.setDuration(210);

        // postavlja animaciju nakon završetka rezerviranog statusa
        ra.setFillAfter(true);

        // Start animacije
        image.startAnimation(ra);
        currentDegree = -degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // trenutno nije u upotrebi ali je potrebno
    }
}