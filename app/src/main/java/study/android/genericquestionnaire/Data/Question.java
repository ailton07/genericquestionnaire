package study.android.genericquestionnaire.Data;

import java.io.Serializable;

/**
 * Created by aluno on 26/09/2016.
 */

public class Question implements Serializable{
        String questionText;
        String answer1, answer2, answer3, trueAnswer;
        String marked;

    public String getMarked() {
        return marked;
    }

    public void setMarked(String marked) {
        this.marked = marked;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getQuestionText() {

        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public Question(String questionText, String answer1, String answer2, String answer3, String trueAnswer) {
            this.questionText = questionText;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
            this.trueAnswer = trueAnswer;
            setMarked(null);
        }

}
