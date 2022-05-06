package com.example.ReactionTime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Privacy extends Activity {

    private String str;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        str = "测试反应时间APP用户隐私政策\n" +
                "\n" +
                "我们深知个人信息对您的重要性，并会尽全力保护您的个人信息安全可靠。我们致力于维持您对我们的信任，恪守以下原则，保护您的个人信息：权责一致原则、目的明确原则、选择同意原则、最少够用原则、确保安全原则、主体参与原则、公开透明原则等。同时，我们承诺，我们将按业界成熟的安全标准，采取相应的安全保护措施来保护您的个人信息。\n" +
                "请在使用我们的产品（或服务）前，仔细阅读并了解本《隐私政策》。\n" +
                "\n" +
                "一、本APP不收集和使用您的个人信息 \n" +
                "个人信息是指以电子或者其他方式记录的能够单独或者与其他信息结合识别特定自然人身份或者反映特定自然人活动情况的各种信息。\n" +
                "\n" +
                "二、本APP不会获取您设备的权限\n";
        txt = findViewById(R.id.textView4);
        txt.setMovementMethod(ScrollingMovementMethod.getInstance());
        txt.setText(str);
    }

    public void onBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}