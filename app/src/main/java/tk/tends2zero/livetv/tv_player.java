package tk.tends2zero.livetv;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class tv_player extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayer player;
    Button fullScreen;
    private int flag;
    TextView textView;
    String videoID;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tv_player);

        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        videoID = b.getString("videoID");
        setTitle(name);
        textView = findViewById(R.id.tvTitle);
        textView.setText(name);

        YouTubePlayerView playerView = (YouTubePlayerView) findViewById(R.id.tv);
        playerView.initialize(DeveloperKey.DEVELOPER_KEY, this);

        fullScreen = (Button) findViewById(R.id.fullscreenTV);

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setFullscreen(true);
                flag = 1;
            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {

        this.player = player;

        if (!b) {

            player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
            // You can change the ID.. of the video to be played
            player.loadVideo(videoID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onBackPressed() {
        if(flag==1) {
            player.setFullscreen(false);
            flag=0;
        }
        else {
            super.onBackPressed();
        }
    }
}