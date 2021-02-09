package ru.geekbrains.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Maths maths;
    private EditText text_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maths = new Maths();
        initView();
    }

    private void initView() {
        text_edit = findViewById(R.id.text_edit);

        initButtonResetClickListener();
        initButtonSevenClickListener();
        initButtonEightClickListener();
        initButtonNineClickListener();
        initButtonSumClickListener();
        initButtonFourClickListener();
        initButtonFiveClickListener();
        initButtonSixClickListener();
        initButtonMinClickListener();
        initButtonOneClickListener();
        initButtonTwoClickListener();
        initButtonThreeClickListener();
        initButtonMulClickListener();
        initButtonZeroClickListener();
        initButtonComClickListener();
        initButtonAnsClickListener();
        initButtonDivClickListener();
    }

    private void initButtonNineClickListener() {
        Button button_nine = findViewById(R.id.button_nine);
        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(9);
                text_edit.setText("9");
            }
        });
    }

    private void initButtonEightClickListener() {
        Button button_eight = findViewById(R.id.button_eight);
        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(8);
                text_edit.setText("8");
            }
        });
    }

    private void initButtonSevenClickListener() {
        Button button_seven = findViewById(R.id.button_seven);
        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(7);
                text_edit.setText("7");
            }
        });
    }

    private void initButtonSixClickListener() {
        Button button_six = findViewById(R.id.button_six);
        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(6);
                text_edit.setText("6");
            }
        });
    }

    private void initButtonFiveClickListener() {
        Button button_five = findViewById(R.id.button_five);
        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(5);
                text_edit.setText("5");
            }
        });
    }

    private void initButtonFourClickListener() {
        Button button_four = findViewById(R.id.button_four);
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(4);
                text_edit.setText("4");
            }
        });
    }

    private void initButtonThreeClickListener() {
        Button button_three = findViewById(R.id.button_three);
        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(3);
                text_edit.setText("3");
            }
        });
    }

    private void initButtonTwoClickListener() {
        Button button_two = findViewById(R.id.button_two);
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(2);
                text_edit.setText("2");
            }
        });
    }

    private void initButtonAnsClickListener() {
        Button button_ans = findViewById(R.id.button_ans);
        button_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.answer();
                text_edit.setText(String.valueOf(maths.getC()));
            }
        });
    }

    private void initButtonComClickListener() {
        Button button_com = findViewById(R.id.button_com);
        button_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                maths.setSign(",");      // пока не работает
            }
        });
    }

    private void initButtonMulClickListener() {
        Button button_mul = findViewById(R.id.button_mul);
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(3);
            }
        });
    }

    private void initButtonMinClickListener() {
        Button button_min = findViewById(R.id.button_min);
        button_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(2);
            }
        });
    }

    private void initButtonDivClickListener() {
        Button button_div = findViewById(R.id.button_div);
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(4);
            }
        });
    }

    private void initButtonSumClickListener() {
        Button button_sum = findViewById(R.id.button_sum);
        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(1);
            }
        });
    }

    private void initButtonOneClickListener() {
        Button button_one = findViewById(R.id.button_one);
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(1);
                text_edit.setText("1");
            }
        });
    }

    private void initButtonZeroClickListener() {
        Button button_zero = findViewById(R.id.button_zero);
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.option(0);
                text_edit.setText("0");
            }
        });
    }

    private void initButtonResetClickListener() {
        Button button_reset = findViewById(R.id.button_reset);
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setA(0);
                maths.setB(0);
                maths.setC(0);
                maths.setSign(0);
                text_edit.setText("0");
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}