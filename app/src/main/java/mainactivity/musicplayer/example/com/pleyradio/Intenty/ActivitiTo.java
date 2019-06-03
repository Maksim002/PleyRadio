package mainactivity.musicplayer.example.com.pleyradio.Intenty;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import mainactivity.musicplayer.example.com.pleyradio.R;

public class ActivitiTo extends AppCompatActivity {
    private Button b_play;

    MediaPlayer mediaPlayer;

    boolean prepared = false;
    boolean started = false;

    String stream = "http://listen.rpfm.ru:9000/premium128";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_radio);


        b_play = findViewById(R.id.p_lay);
        b_play.setEnabled(false);
        b_play.setText("LOADING");

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        new PlayerTask().execute(stream);

        b_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (started){
                    started = false;
                    mediaPlayer.pause();
                    b_play.setText("PLAY");
                }else {
                    started = true;
                    mediaPlayer.start();
                    b_play.setText("PAUSE");
                }
            }
        });
    }


    class PlayerTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepared = true;
            }catch (IOException e){
                e.printStackTrace();
            }
            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            b_play.setEnabled(true);
            b_play.setText("PLAY");

        }
    }
}
