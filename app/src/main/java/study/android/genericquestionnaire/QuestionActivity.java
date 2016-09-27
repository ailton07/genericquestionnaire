package study.android.genericquestionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

import study.android.genericquestionnaire.Data.Questionnaire;

public class QuestionActivity extends AppCompatActivity {

    Questionnaire questionnaire;
    int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Questionário");
        setSupportActionBar(toolbar);

        // Obtain parameters
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        questionNumber = intent.getIntExtra("question", 0);
        questionnaire = (Questionnaire) intent.getSerializableExtra("questionnaire");

        // Numero da questao corrente
        final TextView textView_questionNumber = (TextView) findViewById(R.id.textView_questionNumber);
        textView_questionNumber.setText("Pergunta "+ Integer.toString(questionNumber+1) +"/5");

        // Texto da questao corrente
        final TextView textView_questionText = (TextView) findViewById(R.id.textView_questionText);
        textView_questionText.setText(questionnaire.getQuestions().get(questionNumber).getQuestionText());

        // Alternativas
        final RadioButton radioButton_question1 = (RadioButton) findViewById(R.id.radioButton_question1);
        radioButton_question1.setText(questionnaire.getQuestions().get(questionNumber).getAnswer1());
        final RadioButton radioButton_question2 = (RadioButton) findViewById(R.id.radioButton2_question2);
        radioButton_question2.setText(questionnaire.getQuestions().get(questionNumber).getAnswer2());
        final RadioButton radioButton_question3 = (RadioButton) findViewById(R.id.radioButton_question3);
        radioButton_question3.setText(questionnaire.getQuestions().get(questionNumber).getAnswer3());

//        Log.d("data", name);
//        Log.d("data", questionnaire.getQuestions().get(0).getAnswer1());

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startNextActivity();
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton_question1);
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_question1:
                if (checked)
                    radioButton = (RadioButton) findViewById(R.id.radioButton_question1);
                    questionnaire.getQuestions().get(questionNumber).setMarked(radioButton.getText().toString());
                    break;
            case R.id.radioButton2_question2:
                if (checked)
                    radioButton = (RadioButton) findViewById(R.id.radioButton2_question2);
                    questionnaire.getQuestions().get(questionNumber).setMarked(radioButton.getText().toString());
                    break;
            case R.id.radioButton_question3:
                if (checked)
                    radioButton = (RadioButton) findViewById(R.id.radioButton_question3);
                    questionnaire.getQuestions().get(questionNumber).setMarked(radioButton.getText().toString());
                    break;
            default:
                questionnaire.getQuestions().get(questionNumber).setMarked("none");
        }
    }

    public void startNextActivity() {

        // Checa se o radio box foi selecionado
        if(!(questionnaire.getQuestions().get(questionNumber).getMarked()==(null))) {

            if(questionNumber < 4) {
                Intent secondActivity = new Intent(this, QuestionActivity.class);
                questionNumber = questionNumber + 1;
                secondActivity.putExtra("question", questionNumber);
                secondActivity.putExtra("questionnaire", questionnaire);
                startActivity(secondActivity);
            }
            else{
                Intent finalActivity = new Intent(this, FinalActivity.class);
                finalActivity.putExtra("questionnaire", questionnaire);
                startActivity(finalActivity);
            }
        }
    }

}
