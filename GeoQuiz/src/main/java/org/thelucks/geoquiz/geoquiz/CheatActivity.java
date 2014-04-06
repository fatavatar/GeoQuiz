package org.thelucks.geoquiz.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Andrew on 4/1/2014.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE =
            "org.thelucks.geoquiz.answer_is_true";

    public static final String EXTRA_ANSWER_SHOWN =
            "org.thelucks.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean answerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, answerShown);
        this.setResult(RESULT_OK, data);
    }

    @Override
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        setAnswerShownResult(false);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue)
                {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else
                {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

    }
}
