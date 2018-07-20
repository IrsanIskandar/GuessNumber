package id.co.kreasitindo.ibi.myfirstdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView lblResult;
    EditText edtText;
    Button guess;
    Button reset;

    int generateNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblResult = findViewById(R.id.TxtviewResult);
        edtText = findViewById(R.id.EdtInputNumber);
        guess = findViewById(R.id.BtnGuess);
        reset = findViewById(R.id.BtnReset);

        generateNumber = getRandomNumber(101);

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number;

                number = Integer.parseInt(edtText.getText().toString());
                checkAnswer(number, generateNumber);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumber = getRandomNumber(101);
                edtText.setText("");
            }
        });
    }

    private void checkAnswer(int currentNumber, int random) {

        if (currentNumber > random){
            messsageResult("Angka Telalu besar.");
        } else if (currentNumber < random) {
            messsageResult("Angka Terlalu kecil.");
        } else if(currentNumber == random) {
            messsageResult("Jawaban Anda benar !!! \n Nomor yang benar : " + currentNumber);
        }
    }

    private void messsageResult(String value){
        lblResult.setText(value);
        Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
    }

    private int getRandomNumber(int randomNumber){
        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(randomNumber);

        return  randomNumber;
    }
}
