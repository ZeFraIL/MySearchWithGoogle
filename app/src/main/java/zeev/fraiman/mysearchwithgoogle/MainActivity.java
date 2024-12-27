package zeev.fraiman.mysearchwithgoogle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button bStartSearch;
    Context context;
    ActivityResultLauncher<Intent> arl;
    Uri addressUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        bStartSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go=new Intent(context, Search.class);
                arl.launch(go);
            }
        });
    }

    private void initComponents() {
        context=MainActivity.this;
        tvResult=findViewById(R.id.tvResult);
        bStartSearch=findViewById(R.id.bStartSearch);
        arl=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult ar) {
                        Intent takeresult=ar.getData();
                        String res=takeresult.getStringExtra("result");
                        tvResult.setText(res);

                    }
                });
    }
}