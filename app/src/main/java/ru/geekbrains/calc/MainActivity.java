package ru.geekbrains.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private final static String keyMaths = "Maths";

    // Сохранение данных
    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyMaths, maths);
    }

    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        maths = (Maths) instanceState.getParcelable(keyMaths);
    }

    private Maths maths;
    private EditText text_edit;
    private boolean varSign = false;
    DecimalFormat decimalFormat = new DecimalFormat("#.#######");//только 7 знаков после запятой

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
                display(9);
            }
        });
    }

    private void initButtonEightClickListener() {
        Button button_eight = findViewById(R.id.button_eight);
        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(8);
            }
        });
    }

    private void initButtonSevenClickListener() {
        Button button_seven = findViewById(R.id.button_seven);
        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(7);
            }
        });
    }

    private void initButtonSixClickListener() {
        Button button_six = findViewById(R.id.button_six);
        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(6);
            }
        });
    }

    private void initButtonFiveClickListener() {
        Button button_five = findViewById(R.id.button_five);
        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(5);
            }
        });
    }

    private void initButtonFourClickListener() {
        Button button_four = findViewById(R.id.button_four);
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(4);
            }
        });
    }

    private void initButtonThreeClickListener() {
        Button button_three = findViewById(R.id.button_three);
        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(3);
            }
        });
    }

    private void initButtonTwoClickListener() {
        Button button_two = findViewById(R.id.button_two);
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(2);
            }
        });
    }

    private void initButtonAnsClickListener() {
        Button button_ans = findViewById(R.id.button_ans);
        button_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.answer();
                text_edit.setText(decimalFormat.format(maths.getC()));
            }
        });
    }

    private void initButtonComClickListener() {
        Button button_com = findViewById(R.id.button_com);
        button_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setPoint(true);
                text_edit.setText(text_edit.getText() + ".");
            }
        });
    }

    private void initButtonMulClickListener() {
        Button button_mul = findViewById(R.id.button_mul);
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(3);
                varSign = true;
            }
        });
    }

    private void initButtonMinClickListener() {
        Button button_min = findViewById(R.id.button_min);
        button_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(2);
                varSign = true;
            }
        });
    }

    private void initButtonDivClickListener() {
        Button button_div = findViewById(R.id.button_div);
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(4);
                varSign = true;
            }
        });
    }

    private void initButtonSumClickListener() {
        Button button_sum = findViewById(R.id.button_sum);
        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maths.setSign(1);
                varSign = true;
            }
        });
    }

    private void initButtonOneClickListener() {
        Button button_one = findViewById(R.id.button_one);
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(1);
            }
        });
    }

    private void initButtonZeroClickListener() {
        Button button_zero = findViewById(R.id.button_zero);
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(0);
            }
        });
    }

    private void display(int x) {
        double var;
        if (String.valueOf(text_edit.getText()).equals("0") || varSign) {
            varSign = false;
            var = x;
        } else if (maths.getPoint()) {
            var = Double.parseDouble(decimalFormat.format(aOrB()) + "." + x);
            maths.setPoint(false);
        } else {
            var = Double.parseDouble(decimalFormat.format(aOrB()) + x); //String.valueOf(text_edit.getText()) + x);
        }
        maths.option(var);
        text_edit.setText(decimalFormat.format(var));
    }

    private double aOrB() {
        if (maths.getSign() == 0) {
            return maths.getA();
        } else {
            return maths.getB();
        }
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
                varSign = false;
            }
        });
    }

}