package tk.tends2zero.livetv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class fragment_catmusicTV extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_catmusic, container, false);
        Button watch = v.findViewById(R.id.watch_catmusic);

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tv_player.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","CAT Music");
                bundle.putString("videoID","kgrjY5LlJuc");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return v;
    }
}
