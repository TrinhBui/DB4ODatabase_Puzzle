package btn.k23.dhcantho.db4odatabase;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by sonlonglxag on 12/9/16.
 */

public class DbHelper extends AppCompatActivity {


    int score=0;
    int qid=0;
    Question currentQ;
    ObjectContainer db;

    public DbHelper(ObjectContainer database ) {
        db = database;
        //Insert an object:
        //creates object
        //Person p1  = new Person("Son", 100, "Database@db4o.com");
        //saves object
        /*
        try {
            db.store(p1 );
            addQuestions();
            //----Search all QBE----
            Person person = new Person();
            ObjectSet<Person> persons = db.queryByExample(person);
            for (Person ps: persons){
                Log.e("Test DbHelper: ", ps.toString() );
            }
        } finally {
            db.close();
        }
        */
        addQuestions();
    }

    private void addQuestions() { //---- Chèn dữ liệu - Insert  Database

        Question q1=new Question(1,"The CPU is large chip …………… the computer",
                "","INSIDE","ONTO","OUE","FROM","INSIDE");
        db.store(q1);
        Question q2=new Question(2,"Data always flows …………. The CPU …………The address bus",
                "","FROM/TO","FROM/TO","TO/TO","TO/FROM","ONTO/FROM");
        db.store(q2);
        Log.e("Test addQuestions: ", "OK " );
    }

    public List<Question> getAllQuestions(){ //----add questions to list

        List<Question> quesList = new ArrayList<Question>();

        try{
            //----Search all QBE----
            Question question = new Question();
            ObjectSet<Question> questions = db.queryByExample(question);
            for (Question quest:questions){
                quesList.add(quest);
                Log.e("Quest value: ", quest.getANSWER());
            }
        }finally{
            db.close();
        }
        Log.e("Test get all Questions: ", "OK " );
        return quesList;
    }

    public int rowcount(){ //-----Thuật toán tính điểm trắc nghiệm

        int row=0;

        return row;
    }
}
