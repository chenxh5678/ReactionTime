package com.example.ReactionTime;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private TextView Text1;
    private TextView Text2;
    private double start;
    private double best;
    private int count;
    private SoundPool sp;
    private int id;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSound();
        Button btn = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Text1 = findViewById(R.id.Text1);
        Text2 = findViewById(R.id.Text2);

        ButtonListener b = new ButtonListener(btn);
        btn.setOnTouchListener(b);

        // 重置按钮
        btn2.setOnClickListener(view -> {
            best = 0;
            count = 0;
            Text2.setText("最佳：" + best + "\n" + "次数：" + count);
        });

    }

    //按压事件
    class ButtonListener implements View.OnClickListener, View.OnTouchListener{
        private final Button btn2;
        private Timer timer;

        private int key = 0;

        public ButtonListener(Button btn){  //传递按钮
            this.btn2 = btn;
        }

        @Override
        public void onClick(View view) {

        }

        @SuppressLint({"ClickableViewAccessibility", "SetTextI18n", "UseCompatLoadingForDrawables"})
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(view.getId()==R.id.button1){
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    count++;
                    if (key == 1){
                        double end = System.currentTimeMillis();  //获取结束时间
                        double reaction = (end - start)/1000;  //反应时间
                        Text1.setText("反应时间：" + reaction + "秒");
                        timer.cancel();
                        if (best == 0){
                            best = reaction;
                        }else if(best > reaction){
                            best = reaction;
                        }
                    }else{
                        timer.cancel();
                        Text1.setText("反应时间：犯规");
                    }
                    Text2.setText("最佳：" + best + "\n" + "次数：" + count);
                    btn2.setBackground(getResources().getDrawable(R.drawable.btn_select));
                    btn2.setText("按下");
                    key = 0;

                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    if (key==0) {
                        btn2.setText("预备(按住)");
                        double time = Math.random() * 1 + 1;  //随机time秒
                        int delay = (int) (time * 1000);
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                playSound();
                                btn2.setBackground(getResources().getDrawable(R.drawable.btn_set));
                                btn2.setText("抬起！");
                                start = System.currentTimeMillis();  //获取开始时间
                                key = 1;
                            }
                        }, delay);
                    }
                }
            }
            return false;
        }
    }

    //sound
    private void initSound(){
        sp = new SoundPool.Builder().build();
        id = sp.load(this,R.raw.shoot,0);
    }

    private void playSound(){
        sp.play(id,0.1f,0.5f,0,0,1);
    }


}