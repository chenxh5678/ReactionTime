package com.example.ReactionTime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class user extends Activity {

    private String str;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        str = "用户协议\n" +
                "\n" +
                "本协议为您与本APP管理者之间所订立的契约，具有合同的法律效力，请您仔细阅读。\n" +
                "一、本协议内容、生效、变更\n" +
                "本协议内容包括协议正文及所有本APP已经发布的或将来可能发布的各类规则。所有规则为本协议不可分割的组成部分，与协议正文具有同等法律效力。如您对协议有任何疑问，应向本APP咨询。\n" +
                "只要您使用本APP服务，则本协议即对您产生约束，届时您不应以未阅读本协议的内容或者未获得本APP对您问询的解答等理由，主张本协议无效，或要求撤销本协议。您确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。 \n" +
                "您承诺接受并遵守本协议的约定。如果您不同意本协议的约定，您应立即停止使用本APP。本APP有权根据需要不定期地制订、修改本协议及/或各类规则，并在本APP平台公示，不再另行单独通知用户。变更后的协议和规则一经在网站公布，立即生效。如您不同意相关变更，应当立即停止使用本APP。您继续使用本APP，即表明您接受修订后的协议和规则。\n" +
                "二、免责条款\n" +
                "本APP仅提供信息对接，发生一切纠纷问题皆与本APP无关，请通过仲裁部门维护各自权益。";
        txt = findViewById(R.id.textView3);
        txt.setMovementMethod(ScrollingMovementMethod.getInstance());
        txt.setText(str);
    }

    public void onBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}