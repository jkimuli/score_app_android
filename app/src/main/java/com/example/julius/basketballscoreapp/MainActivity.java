package com.example.julius.basketballscoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


    }

    public void startGame(View view) {

        // reset all team scores to zero

        mScore_A = 0;
        mScore_B = 0;

        team_a_score.setText(Integer.toString(mScore_A));
        team_b_score.setText(Integer.toString(mScore_B));

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

    public void endGame(View view) {

        // disable points buttons and the end game button

        end_game.setEnabled(false);
        team_a_1.setEnabled(false);
        team_a_2.setEnabled(false);
        team_a_3.setEnabled(false);
        team_b_1.setEnabled(false);
        team_b_2.setEnabled(false);
        team_b_3.setEnabled(false);

        // enable the start game button

        start_game.setEnabled(true);

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
                throw new RuntimeException("Unkown Button ID");
        }

    }
}
