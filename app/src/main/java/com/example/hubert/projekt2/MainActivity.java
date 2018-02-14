package com.example.hubert.projekt2;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    private static int activePlayer = 0; //cross

    private ImageView imageView10;
    private TextView textViewWinner;
    private TextView textView;

    private static int[] state = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    private static int[][] win ={{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};



    private static boolean over = false;




    public void game(View view){
        ImageView tappedView = (ImageView) view;



        imageView10 = (ImageView) findViewById(R.id.imageView10);

        textViewWinner = (TextView) findViewById(R.id.textViewWinner);

        textView = (TextView) findViewById(R.id.textView);

        int tappedLocation = Integer.parseInt(view.getTag().toString());

        if(state[tappedLocation] == 2 && over == false) {

            state[tappedLocation] = activePlayer;


            if (activePlayer == 0) {

                imageView10.setImageResource(R.drawable.circle);

                tappedView.setImageResource(R.drawable.cross);
                activePlayer = 1;


            } else if (activePlayer == 1) {

                imageView10.setImageResource(R.drawable.cross);

                tappedView.setImageResource(R.drawable.circle);
                activePlayer = 0;


            }
        }



        for (int[] win_position : win){

            if(state[win_position[0]] == state[win_position[1]] && state[win_position[1]]==state[win_position[2]] && state[win_position[0]] !=2){

                if(activePlayer == 1)
                {
                    textViewWinner.setText("WYGRYWA X");
                }

                if(activePlayer == 0)
                {
                    textViewWinner.setText("WYGRYWA O");
                }

                over = true;

                imageView10.setImageResource(R.drawable.blank);
                textView.setText("");



            }



        }

        if(!over){
            for (int i : state){

                if(i == 2){

                    over = false;
                    break;
                }
                else over= true;
            }

            if(over){
                textViewWinner.setText("REMIS");
                imageView10.setImageResource(R.drawable.blank);
                textView.setText("");

            }

        }


    }

    public void nowaGra(){
        over = false;
        //activePlayer = 0;

        for (int i = 0 ; i < state.length; i++){
            state[i] = 2;
        }


        if (activePlayer==0) {
            imageView10.setImageResource(R.drawable.cross);
        }
        else imageView10.setImageResource(R.drawable.circle);
        textViewWinner.setText("");
        textView.setText("Teraz kolej:");




        ImageView imageView0 = (ImageView) findViewById(R.id.imageView0);
        imageView0.setImageResource(R.drawable.blank);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setImageResource(R.drawable.blank);

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.blank);

        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setImageResource(R.drawable.blank);

        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setImageResource(R.drawable.blank);

        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView5.setImageResource(R.drawable.blank);

        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView6.setImageResource(R.drawable.blank);

        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView7.setImageResource(R.drawable.blank);

        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setImageResource(R.drawable.blank);


    }





    protected void onResume(){
        super.onResume();


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nowaGra:
                nowaGra();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
