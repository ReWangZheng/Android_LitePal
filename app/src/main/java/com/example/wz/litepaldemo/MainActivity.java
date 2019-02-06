package com.example.wz.litepaldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Connector.getDatabase();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                student stu1=new student();
                stu1.setName("王正");
                stu1.setCore(80);
                stu1.save();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                student stu2=new student();
                stu2.setName("张大凯");
                stu2.setCore(90);
                stu2.updateAll("name=?","张凯");
                /*stu2.save();
                stu2.setCore(85);
                stu2.save();*/


            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<student> list=DataSupport.where("core=80").find(student.class);
                list.get(0).delete();
                DataSupport.deleteAll(student.class,"core=?","90");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<student> list=DataSupport.findAll(student.class);
                for(student s:list)
                {
                    Log.d("MainActivity",s.getName()+"   "+s.getCore());
                }
            }
        });
    }
}
