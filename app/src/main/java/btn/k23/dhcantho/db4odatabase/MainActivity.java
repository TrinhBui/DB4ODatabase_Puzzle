package btn.k23.dhcantho.db4odatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtCheck;
    TextView txtQuestion;
    TextView txtSample;
    RadioButton rda, rdb, rdc, rdd;
    Button btnChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mappings with interface
        txtCheck = (TextView) findViewById(R.id.txtCheck);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtSample = (TextView) findViewById(R.id.txtSample);
        rda = (RadioButton) findViewById(R.id.radioButton1);
        rdb = (RadioButton) findViewById(R.id.radioButton2);
        rdc = (RadioButton) findViewById(R.id.radioButton3);
        rdd = (RadioButton) findViewById(R.id.radioButton4);
        btnChoice = (Button) findViewById(R.id.btnChoise);
        Log.e("mapping interface: ", "OK " );

        //Create the DB:
        String dbPath =  "/data/data/" + getPackageName() + "/Db4oDatabase.db4o";
        Log.e("String Data Main: ",dbPath);
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbPath);
        DbHelper data =new DbHelper(db);
        quesList=data.getAllQuestions();
        currentQ=quesList.get(qid);
        setQuestionView();


        btnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp=(RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.e("Check answer: ", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     return super.onCreateOptionsMenu(menu);
    }

    private void setQuestionView() {
        Log.e("Set QuestionView: ", "Begin ...  " );
        txtQuestion.setText(currentQ.getQUESTION());
        Log.e("Set QuestionView: ", "Question value OK " );
        txtSample.setText(currentQ.getSAMPLE());
        Log.e("Set QuestionView: ", "Sample value OK " );
        rda.setText(currentQ.getOPTA());
        Log.e("Set QuestionView: ", "A value OK " );
        rdb.setText(currentQ.getOPTB());
        Log.e("Set QuestionView: ", "B value OK " );
        rdc.setText(currentQ.getOPTC());
        Log.e("Set QuestionView: ", "C value OK " );
        rdd.setText(currentQ.getOPTD());
        Log.e("Set QuestionView: ", "D value OK " );
        qid++;
        Log.e("Set QuestionView: ", "End -- OK " );


    }
}
