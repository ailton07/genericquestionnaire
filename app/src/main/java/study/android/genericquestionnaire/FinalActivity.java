package study.android.genericquestionnaire;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import study.android.genericquestionnaire.Data.Questionnaire;

public class FinalActivity extends AppCompatActivity {

    Questionnaire questionnaire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain parameters
        Intent intent = getIntent();
        questionnaire = (Questionnaire) intent.getSerializableExtra("questionnaire");

        TextView textView_name = (TextView) findViewById(R.id.textView_name);
        textView_name.setText("Nome:  "+questionnaire.getName());

        // Este processo poderia ser automatizado, porém, por questões relativas ao tempo
        // será feito da maneira manual
        LinearLayout linearLayout_Questions = (LinearLayout) findViewById(R.id.LinearLayout_Questions);
        // Question 1
        criaTextView("PERGUNTA: ", questionnaire.getQuestions().get(0).getQuestionText(),linearLayout_Questions, 0);
        criaTextView("a) ", questionnaire.getQuestions().get(0).getAnswer1(),linearLayout_Questions, 0);
        criaTextView("b) ", questionnaire.getQuestions().get(0).getAnswer2(),linearLayout_Questions, 0);
        criaTextView("c) ", questionnaire.getQuestions().get(0).getAnswer3(),linearLayout_Questions, 0);
        // Question 2
        criaTextView("PERGUNTA: ", questionnaire.getQuestions().get(1).getQuestionText(),linearLayout_Questions, 1);
        criaTextView("a) ", questionnaire.getQuestions().get(1).getAnswer1(),linearLayout_Questions, 1);
        criaTextView("b) ", questionnaire.getQuestions().get(1).getAnswer2(),linearLayout_Questions, 1);
        criaTextView("c) ", questionnaire.getQuestions().get(1).getAnswer3(),linearLayout_Questions, 1);
        // Question 3
        int aux =2;
        criaTextView("PERGUNTA: ", questionnaire.getQuestions().get(aux).getQuestionText(),linearLayout_Questions, aux);
        criaTextView("a) ", questionnaire.getQuestions().get(aux).getAnswer1(),linearLayout_Questions, aux);
        criaTextView("b) ", questionnaire.getQuestions().get(aux).getAnswer2(),linearLayout_Questions, aux);
        criaTextView("c) ", questionnaire.getQuestions().get(aux).getAnswer3(),linearLayout_Questions, aux);

        // Question 4
        aux = 3;
        criaTextView("PERGUNTA: ", questionnaire.getQuestions().get(aux).getQuestionText(),linearLayout_Questions, aux);
        criaTextView("a) ", questionnaire.getQuestions().get(aux).getAnswer1(),linearLayout_Questions, aux);
        criaTextView("b) ", questionnaire.getQuestions().get(aux).getAnswer2(),linearLayout_Questions, aux);
        criaTextView("c) ", questionnaire.getQuestions().get(aux).getAnswer3(),linearLayout_Questions, aux);

        // Question 5
        aux = 4;
        criaTextView("PERGUNTA: ", questionnaire.getQuestions().get(aux).getQuestionText(),linearLayout_Questions, aux);
        criaTextView("a) ", questionnaire.getQuestions().get(aux).getAnswer1(),linearLayout_Questions, aux);
        criaTextView("b) ", questionnaire.getQuestions().get(aux).getAnswer2(),linearLayout_Questions, aux);
        criaTextView("c) ", questionnaire.getQuestions().get(aux).getAnswer3(),linearLayout_Questions, aux);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startNextActivity();
            }
        });
    }

    void criaTextView(String text1, String text2, LinearLayout linearLayout, int question){
        TextView textView = new TextView(this);
        if(text2.equals(questionnaire.getQuestions().get(question).getMarked()))
            textView.setTextColor(Color.RED);
        if(text2.equals(questionnaire.getQuestions().get(question).getTrueAnswer()))
            textView.setTextColor(Color.GREEN);
        textView.setText(text1+text2);
        linearLayout.addView(textView);
    }

    void criaTextViewGreen(String text, LinearLayout linearLayout){
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextColor(Color.GREEN);
        linearLayout.addView(textView);
    }
    public void startNextActivity() {

        // Checa se o radio box foi selecionado

                Intent finalActivity = new Intent(this, MainActivity.class);

                startActivity(finalActivity);

        }




}
