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

public class fragment_ntv extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_ntv, container, false);
        Button watch = v.findViewById(R.id.watch_ntv);

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tv_player.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","NTV");
                bundle.putString("videoID","EIrzROTlxfI");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return v;
    }
}
