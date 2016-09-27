package study.android.genericquestionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import study.android.genericquestionnaire.Data.Questionnaire;

public class MainActivity extends AppCompatActivity {

    Questionnaire questionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carregamento das questões
        questionnaire = new Questionnaire();


        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startNextActivity();
            }
        });
    }

    public void startNextActivity() {

        EditText name = (EditText) findViewById(R.id.editTextName);
        if(!(name.getText().toString().equals(""))) {
            questionnaire.setName(name.getText().toString());
            Intent secondActivity = new Intent(this, QuestionActivity.class);
            secondActivity.putExtra("name", name.getText().toString());
            secondActivity.putExtra("question", 0);
            secondActivity.putExtra("questionnaire", questionnaire);
            startActivity(secondActivity);
        }
    }


}
