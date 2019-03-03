package tk.tends2zero.livetv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class report extends Fragment {
    private DatabaseReference databaseReference;
    private Button buttonSubmit;
    private EditText emailID,reportText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.report, container, false);

        buttonSubmit = v.findViewById(R.id.submit);
        emailID = v.findViewById(R.id.email);
        reportText = v.findViewById(R.id.report);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("reports");

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reportDetails = reportText.getText().toString().trim();
                String emailAddress = emailID.getText().toString().trim();
                databaseReference.push().setValue(emailAddress);
                databaseReference.push().setValue(reportDetails);
                Toast.makeText(getActivity(),"Report has been acknowledged",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        return v;
    }
}
