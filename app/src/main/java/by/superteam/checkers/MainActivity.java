package by.superteam.checkers;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView[][] board;
    int[] columns = {R.id.a, R.id.b, R.id.c, R.id.d, R.id.e, R.id.f, R.id.g, R.id.h};
    int white = Color.WHITE;
    int black = R.drawable.black_back;
    int whiteCheck = R.drawable.white;
    int blackCheck = R.drawable.black;
    int blue = R.drawable.blue;
    int EMPTY = 0;
    int BLACK = 1;
    int WHITE = 2;
    int BLUE = 3;
    int WHITE_BLUE = 4;
    int FIGHT = 5;

    int KING = 6;
    int KING_BLUE = 7;
    int BLUE_FOR_KING = 8;
    int whiteKing = R.drawable.white_king;
int red=R.drawable.red;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = new ImageView[8][8];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        View.OnTouchListener listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ImageView it = (ImageView) v;
                    if (((int) it.getTag(R.id.c)) == KING) {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (((int) board[i][j].getTag(R.id.c)) == BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == BLUE_FOR_KING) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == WHITE_BLUE) {
                                    board[i][j].setTag(R.id.c, WHITE);
                                    board[i][j].setBackgroundResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == FIGHT) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == KING_BLUE) {
                                    board[i][j].setTag(R.id.c, KING);
                                    board[i][j].setBackgroundResource(black);
                                }

                            }
                        }
                        int i = (int) v.getTag(R.id.a);
                        int j = (int) v.getTag(R.id.b);
v.setTag(R.id.c,KING_BLUE);

                            markForKing(0, v,false,false,false,false);



                    }
                    if (((int) it.getTag(R.id.c)) == WHITE) {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (((int) board[i][j].getTag(R.id.c)) == BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == WHITE_BLUE) {
                                    board[i][j].setTag(R.id.c, WHITE);
                                    board[i][j].setBackgroundResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == FIGHT) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == KING_BLUE) {
                                    board[i][j].setTag(R.id.c, KING);
                                    board[i][j].setBackgroundResource(black);
                                }
                            }
                        }
                        int i = (int) v.getTag(R.id.a);
                        int j = (int) v.getTag(R.id.b);

                        if (i > 0 && ((int) board[i - 1][j - 1].getTag(R.id.c) == EMPTY)) {
                            board[i - 1][j - 1].setImageResource(blue);
                            board[i - 1][j - 1].setTag(R.id.c, BLUE);
                            v.setBackgroundResource(blue);
                            v.setTag(R.id.c, WHITE_BLUE);
                        }
                        if (i < 7 && ((int) board[i + 1][j - 1].getTag(R.id.c) == EMPTY)) {
                            board[i + 1][j - 1].setImageResource(blue);
                            board[i + 1][j - 1].setTag(R.id.c, BLUE);
                            v.setBackgroundResource(blue);
                            v.setTag(R.id.c, WHITE_BLUE);
                        }
                        checkFight(i, j);

                    }
                    if (((int) v.getTag(R.id.c)) == BLUE) {
                        int x;
                        int y;
                        boolean isKing = false;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (((int) board[i][j].getTag(R.id.c)) == BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == WHITE_BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setBackgroundResource(black);
                                    board[i][j].setImageResource(black);
                                    x = i;
                                    y = j;
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == KING_BLUE) {
                                    isKing = true;
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setBackgroundResource(black);
                                    board[i][j].setImageResource(black);
                                    x = i;
                                    y = j;
                                    board[x][y].setTag(R.id.c,KING);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == FIGHT) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }


                            }
                        }

                        if (isKing) {
                            v.setTag(R.id.c, KING);
                            ((ImageView) v).setImageResource(whiteKing);
                        } else {
                            v.setTag(R.id.c, WHITE);
                            ((ImageView) v).setImageResource(whiteCheck);
                        }
                        if ((int) v.getTag(R.id.b) == 0) makeKing((int) v.getTag(R.id.a));
                    }

                    if (((int) v.getTag(R.id.c)) == FIGHT) {
                        int x = 0;
                        int y = 0;
                        int tag = 0;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (((int) board[i][j].getTag(R.id.c)) == BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == WHITE_BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setBackgroundResource(black);
                                    board[i][j].setImageResource(black);
                                    x = i;
                                    y = j;
                                    tag=WHITE;
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == KING_BLUE) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setBackgroundResource(black);
                                    board[i][j].setImageResource(black);
                                    x = i;
                                    y = j;
                                    tag=KING;
                                }
                                if (((int) board[i][j].getTag(R.id.c)) == FIGHT) {
                                    board[i][j].setTag(R.id.c, EMPTY);
                                    board[i][j].setImageResource(black);
                                }


                            }
                        }
                        if(tag==WHITE)((ImageView) v).setImageResource(whiteCheck);
                        if(tag==KING)((ImageView) v).setImageResource(whiteKing);
                        v.setTag(R.id.c, tag);
                        int i = (x - (int) v.getTag(R.id.a)) ;
                        if(i<0)i=-1;
                        if(i>0)i=1;
                        int j = (y - (int) v.getTag(R.id.b)) ;
                        if(j<0)j=-1;
                        if(j>0)j=1;
                        int x1=(int)v.getTag(R.id.b) +j;
                        int y1=(int)v.getTag(R.id.a) +i;
                        ImageView dead = board[y1][x1];
                        dead.setTag(R.id.c, EMPTY);
                        dead.setImageResource(black);
                        if ((int) v.getTag(R.id.b) == 0&&(int)v.getTag(R.id.c)!=KING) makeKing((int) v.getTag(R.id.a));
                    }
                }
                return true;
            }
        };
        for (int i = 0; i < 8; i++) {
            LinearLayout linearLayout = (LinearLayout) findViewById(columns[i]);
            for (int j = 0; j < 8; j++) {
                ImageView textView = new ImageView(this);

                board[i][j] = textView;
                textView.setLayoutParams(lp);
                if (i % 2 == 0 && j % 2 == 0) {
                    textView.setBackgroundColor(white);
                }
                if (i % 2 == 1 && j % 2 == 0) {
                    textView.setBackgroundResource(black);
                    textView.setImageResource(black);
                    textView.setOnTouchListener(listener);
                }
                if (i % 2 == 0 && j % 2 == 1) {
                    textView.setBackgroundResource(black);
                    textView.setImageResource(black);
                    textView.setOnTouchListener(listener);
                }
                if (i % 2 == 1 && j % 2 == 1) {
                    textView.setBackgroundColor(white);
                }
                textView.setTag(R.id.a, i);
                textView.setTag(R.id.b, j);
                textView.setTag(R.id.c, EMPTY);
                linearLayout.addView(textView, lp);
            }
        }
       /* for(int i=0;i<8;i++){
            for(int j=0;j<3;j++){
                if(i%2==1&&j%2==0){
                    board[i][j].setImageResource(blackCheck);
                    board[i][j].setTag(R.id.c,BLACK);
                }
                if(i%2==0&&j%2==1){
                    board[i][j].setImageResource(blackCheck);
                    board[i][j].setTag(R.id.c,BLACK);
                }
            }
        }*/
        board[2][3].setImageResource(blackCheck);
        board[2][3].setTag(R.id.c, BLACK);
        for (int i = 0; i < 8; i++) {
            for (int j = 5; j < 8; j++) {
                if (i % 2 == 1 && j % 2 == 0) {
                    board[i][j].setImageResource(whiteCheck);
                    board[i][j].setTag(R.id.c, WHITE);
                }
                if (i % 2 == 0 && j % 2 == 1) {
                    board[i][j].setImageResource(whiteCheck);
                    board[i][j].setTag(R.id.c, WHITE);
                }
            }
        }
    }

    public void makeKing(int i) {
        int j = 0;
        board[i][j].setTag(R.id.c, KING);
        board[i][j].setImageResource(whiteKing);
    }

    public void checkFight(int i, int j) {
        ImageView v = board[i][j];
        if (i > 1 && ((int) board[i - 1][j - 1].getTag(R.id.c) == BLACK)) {
            board[i - 2][j - 2].setImageResource(red);
            board[i - 2][j - 2].setTag(R.id.c, FIGHT);
            v.setBackgroundResource(blue);
            v.setTag(R.id.c, WHITE_BLUE);
        }
        if (i < 6 && ((int) board[i + 1][j - 1].getTag(R.id.c) == BLACK)) {
            board[i + 2][j - 2].setImageResource(red);
            board[i + 2][j - 2].setTag(R.id.c, FIGHT);
            v.setBackgroundResource(blue);
            v.setTag(R.id.c, WHITE_BLUE);
        }
        if (i > 1 && ((int) board[i - 1][j + 1].getTag(R.id.c) == BLACK)) {
            board[i - 2][j + 2].setImageResource(red);
            board[i - 2][j + 2].setTag(R.id.c, FIGHT);
            v.setBackgroundResource(blue);
            v.setTag(R.id.c, WHITE_BLUE);
        }
        if (i < 6 && ((int) board[i + 1][j + 1].getTag(R.id.c) == BLACK)) {
            board[i + 2][j + 2].setImageResource(red);
            board[i + 2][j + 2].setTag(R.id.c, FIGHT);
            v.setBackgroundResource(blue);
            v.setTag(R.id.c, WHITE_BLUE);
        }
    }

    public void markForKing(int radius, View king,boolean b0,boolean b1,boolean b2,boolean b3) {
        int i = (int) king.getTag(R.id.a);
        int j = (int) king.getTag(R.id.b);
        try {
            if (i > 0 && ((int) board[i - radius][j - radius].getTag(R.id.c) == EMPTY)) {
                board[i - radius][j - radius].setImageResource(blue);
                board[i - radius][j - radius].setTag(R.id.c, BLUE);
                king.setBackgroundResource(blue);
                king.setTag(R.id.c, KING_BLUE);
            }
            if (i > 0 && ((int) board[i - radius][j - radius].getTag(R.id.c) == BLACK&&b0==false)) {
               b0=true;
                if(((int) board[i - radius-1][j - radius-1].getTag(R.id.c) == EMPTY)){
                    
                    board[i - radius-1][j - radius-1].setTag(R.id.c,FIGHT);
                    board[i - radius-1][j - radius-1].setImageResource(red);
                }
            }
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            if (i < 7 && ((int) board[i + radius][j - radius].getTag(R.id.c) == EMPTY)) {
                board[i + radius][j - radius].setImageResource(blue);
                board[i + radius][j - radius].setTag(R.id.c, BLUE);
                king.setBackgroundResource(blue);
                king.setTag(R.id.c, KING_BLUE);
            }
            if (i > 0 && ((int) board[i + radius][j - radius].getTag(R.id.c) == BLACK&&b1==false)) {
                b1=true;
                if(((int) board[i + radius+1][j - radius-1].getTag(R.id.c) == EMPTY)){
                    board[i + radius+1][j - radius-1].setTag(R.id.c,FIGHT);
                    board[i + radius+1][j - radius-1].setImageResource(red);
                }
            }
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            if (i > 0 && ((int) board[i - radius][j + radius].getTag(R.id.c) == EMPTY)) {

                    board[i - radius][j + radius].setImageResource(blue);
                    board[i - radius][j + radius].setTag(R.id.c, BLUE);
                    king.setBackgroundResource(blue);
                    king.setTag(R.id.c, KING_BLUE);

            } if (i > 0 && ((int) board[i - radius][j + radius].getTag(R.id.c) == BLACK&&b2==false)) {
                b2=true;
                if(((int) board[i - radius-1][j + radius+1].getTag(R.id.c) == EMPTY)){
                    board[i - radius-1][j + radius+1].setTag(R.id.c,FIGHT);
                    board[i - radius-1][j + radius+1].setImageResource(red);
                }
            }
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            if (i < 7 && ((int) board[i + radius][j + radius].getTag(R.id.c) == EMPTY)) {
                board[i + radius][j + radius].setImageResource(blue);
                board[i + radius][j + radius].setTag(R.id.c, BLUE);
                king.setBackgroundResource(blue);
                king.setTag(R.id.c, KING_BLUE);
            }
            if (i > 0 && ((int) board[i + radius][j + radius].getTag(R.id.c) == BLACK&&b3==false)) {
                b3=true;
                if(((int) board[i + radius+1][j + radius+1].getTag(R.id.c) == EMPTY)){
                    board[i + radius+1][j + radius+1].setTag(R.id.c,FIGHT);
                    board[i + radius-1][j + radius+1].setImageResource(red);
                }
            }
        } catch (IndexOutOfBoundsException e) {
        }
        if(radius!=5){
            markForKing(radius+1,king,b0,b1,b2,b3);
        }
    }
}
