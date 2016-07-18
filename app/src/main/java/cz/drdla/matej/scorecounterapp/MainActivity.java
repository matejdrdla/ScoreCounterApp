package cz.drdla.matej.scorecounterapp;


        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counterA = 0;
    int counterB = 0;
    TextView txtAScore;
    TextView txtBScore;
    Button btnAPlusOne;
    Button btnBPlusOne;
    Button btnAPlusTwo;
    Button btnBPlusTwo;
    Button btnAPlusThree;
    Button btnBPlusThree;
    Button btnReset;
    Button btnSend;
    String hello, body, greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //THIS IS TEST OF COMMIT AND PUSH
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAScore = (TextView) findViewById(R.id.text_team_a_score);
        txtBScore = (TextView) findViewById(R.id.text_team_b_score);
        btnAPlusOne = (Button) findViewById(R.id.btn_team_a_plus_one);
        btnBPlusOne = (Button) findViewById(R.id.btn_team_b_plus_one);
        btnAPlusTwo = (Button) findViewById(R.id.btn_team_a_plus_two);
        btnBPlusTwo = (Button) findViewById(R.id.btn_team_b_plus_two);
        btnAPlusThree = (Button) findViewById(R.id.btn_team_a_plus_three);
        btnBPlusThree = (Button) findViewById(R.id.btn_team_b_plus_three);
        btnReset = (Button) findViewById(R.id.btn_reset);
        btnSend = (Button) findViewById(R.id.btn_send);
        hello = getResources().getString(R.string.hello);
        body = getResources().getString(R.string.body);
        greeting = getResources().getString(R.string.greeting);

        addOnePoint();
        addTwoPoint();
        addThreePoint();
        reset();
        send();
    }

    private void addOnePoint() {
        btnAPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterA++;
                txtAScore.setText(Integer.toString(counterA));
            }
        });
        btnBPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterB++;
                txtBScore.setText(Integer.toString(counterB));
            }
        });
    }

    private void addTwoPoint() {
        btnAPlusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterA++;
                counterA++;
                txtAScore.setText(Integer.toString(counterA));
            }
        });
        btnBPlusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterB++;
                counterB++;
                txtBScore.setText(Integer.toString(counterB));
            }
        });
    }

    private void addThreePoint() {
        btnAPlusThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterA++;
                counterA++;
                counterA++;
                txtAScore.setText(Integer.toString(counterA));
            }
        });
        btnBPlusThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterB++;
                counterB++;
                counterB++;
                txtBScore.setText(Integer.toString(counterB));
            }
        });
    }


    private void reset() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterA = 0;
                counterB = 0;
                txtAScore.setText(Integer.toString(counterA));
                txtBScore.setText(Integer.toString(counterB));
            }
        });
    }

    private void send() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = hello + ",\n" + body + " " + counterA + ":" + counterB + ".\n" + greeting + "!";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, counterA + ":" + counterB);
                intent.putExtra(Intent.EXTRA_TEXT, msg);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
        reset();
    }

}
