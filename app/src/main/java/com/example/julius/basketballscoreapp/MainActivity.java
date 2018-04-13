package com.example.julius.basketballscoreapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private int mScore_A;   // variable keeps track of team A score
        private int mScore_B;   // variable keeps track of team B score

        private TextView team_a_score;
        private TextView team_b_score;

        private Button team_a_3;
        private Button team_a_2;
        private Button team_a_1;

        private Button team_b_3;
        private Button team_b_2;
        private Button team_b_1;

        private Button end_game;
        private Button start_game;

        private EditText team_a;
        private EditText team_b;

        private TextView team_a_txt;
        private TextView team_b_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team_a_score = (TextView)findViewById(R.id.textView_score_A);
        team_b_score = (TextView)findViewById(R.id.textView_score_B);

        team_a_3 = (Button)findViewById(R.id.button_score_a_3);
        team_a_2 = (Button)findViewById(R.id.button_score_a_2);
        team_a_1= (Button)findViewById(R.id.button_score_a_1);

        team_b_3 = (Button)findViewById(R.id.button_score_b_3);
        team_b_2 = (Button)findViewById(R.id.button_score_b_2);
        team_b_1= (Button)findViewById(R.id.button_score_b_1);

        end_game = (Button)findViewById(R.id.button_end);
        start_game = (Button)findViewById(R.id.button_start);

        //team_a = (EditText)findViewById(R.id.editText_A);
        //team_b = (EditText)findViewById(R.id.editText_B);

        team_a_txt = (TextView) findViewById(R.id.textView_A);
        team_b_txt = (TextView)findViewById(R.id.textView_B);


    }

    public void startGame(View view) {

        // reset all team scores to zero

        mScore_A = 0;
        mScore_B = 0;

        team_a_score.setText(Integer.toString(mScore_A));
        team_b_score.setText(Integer.toString(mScore_B));

        // display an alert dialog to enter team names

        final View dialog_view = this.getLayoutInflater().inflate(R.layout.teams,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle("Enter the team names");
        builder.setView(dialog_view);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                team_a = (EditText)dialog_view.findViewById(R.id.editText_A);
                team_b = (EditText)dialog_view.findViewById(R.id.editText_B);

                if(TextUtils.isEmpty(team_a.getText().toString()) || TextUtils.isEmpty(team_b.getText().toString())){

                    dialogInterface.dismiss(); // dismiss dialog if any of the team names are missing

                }

                else{

                    team_a_txt.setText(team_a.getText().toString());
                    team_b_txt.setText(team_b.getText().toString());

                    // enable end game button and the point buttons

                    end_game.setEnabled(true);
                    team_a_1.setEnabled(true);
                    team_a_2.setEnabled(true);
                    team_a_3.setEnabled(true);
                    team_b_1.setEnabled(true);
                    team_b_2.setEnabled(true);
                    team_b_3.setEnabled(true);

                    //disable start game button

                    start_game.setEnabled(false);
                }

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

            }
        });

        builder.show();

    }

    public void endGame(View view) {

        // disable points buttons and the end game button

        end_game.setEnabled(false);
        team_a_1.setEnabled(false);
        team_a_2.setEnabled(false);
        team_a_3.setEnabled(false);
        team_b_1.setEnabled(false);
        team_b_2.setEnabled(false);
        team_b_3.setEnabled(false);

        // reset the team names to the default

        team_a_txt.setText(R.string.string_team_a);
        team_b_txt.setText(R.string.string_team_b);

        // enable the start game button

        start_game.setEnabled(true);

        // save the scores to a file on the device



    }

    public void set_team_a_score(View view) {

        switch (view.getId()){

            case R.id.button_score_a_3:
                mScore_A = mScore_A + 3;
                team_a_score.setText(Integer.toString(mScore_A));
                break;

            case R.id.button_score_a_2:
                mScore_A = mScore_A + 2;
                team_a_score.setText(Integer.toString(mScore_A));
                break;

            case R.id.button_score_a_1:
                mScore_A++;
                team_a_score.setText(Integer.toString(mScore_A));
                break;

            default:
                throw new RuntimeException("Unknown Button ID");
        }

    }

    public void set_team_b_score(View view) {

        switch (view.getId()){

            case R.id.button_score_b_3:
                mScore_B = mScore_B + 3;
                team_b_score.setText(Integer.toString(mScore_B));
                break;

            case R.id.button_score_b_2:
                mScore_B = mScore_B + 2;
                team_b_score.setText(Integer.toString(mScore_B));
                break;

            case R.id.button_score_b_1:
                mScore_B++;
                team_b_score.setText(Integer.toString(mScore_B));
                break;

            default:
                throw new RuntimeException("Unknown Button ID");
        }

    }
}
