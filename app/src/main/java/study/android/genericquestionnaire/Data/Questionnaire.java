package study.android.genericquestionnaire.Data;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Created by aluno on 26/09/2016.
 */

public class Questionnaire implements Serializable {
    // Classe responsável por alimentar as perguntas e respostas
    // Na prática, as perguntas e respostas podem ser carregadas dinamicamente
    // através de uma requisição. Por praticidade, aqui serão carregadas estaticamente.

    // Método responsável por criar as questões
    List<Question> Questions;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Questionnaire() {
        this.Questions = populateQuestions();
    }

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<Question> questions) {
        Questions = questions;
    }

    // Método responsável por criar a lista de questões
    public List<Question> populateQuestions(){
        List<Question> Questions = new ArrayList<Question>() ;
        Question question1 = new Question("Qual a capital do Brasil?", "Rio de Janeiro", "Manaus", "Brasília", "Brasília");
        Question question2 = new Question("Qual a capital do Brasil?", "Rio de Janeiro", "Manaus", "Brasília", "Brasília");
        Question question3 = new Question("Qual a capital do Brasil?", "Rio de Janeiro", "Manaus", "Brasília", "Brasília");
        Question question4 = new Question("Qual a capital do Brasil?", "Rio de Janeiro", "Manaus", "Brasília", "Brasília");
        Question question5 = new Question("Qual a capital do Brasil?", "Rio de Janeiro", "Manaus", "Brasília", "Brasília");

        Questions.add(question1);
        Questions.add(question2);
        Questions.add(question3);
        Questions.add(question4);
        Questions.add(question5);

        return Questions;

    }
}


