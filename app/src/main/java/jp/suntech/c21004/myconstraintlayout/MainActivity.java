package jp.suntech.c21004.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btsend = findViewById(R.id.btSend);

        HelloListener listener = new HelloListener();

        btsend.setOnClickListener(listener);

        Button btclear = findViewById(R.id.btclear);

        btclear.setOnClickListener(listener);

        Button btconfirm = findViewById(R.id.btConfirm);

        btconfirm.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();

            int id = view.getId();

            EditText inputcomment = findViewById(R.id.etComment);

            EditText inputname = findViewById(R.id.etName);

            EditText inputtitle = findViewById(R.id.etMail);

            EditText inputmail = findViewById(R.id.etMail2);

            String inputcommentStr = inputcomment.getText().toString();

            String inputnameStr = inputname.getText().toString();

            String inputtitleStr = inputtitle.getText().toString();

            String inputmailStr = inputmail.getText().toString();

            String show = "送信確認\n" + "名前:" + inputnameStr + "\nタイトル:" + inputtitleStr + "\nメールアドレス:" + inputmailStr + "\n質問内容:" + inputcommentStr;

            switch (id) {
                case R.id.btSend:
                    Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btclear:
                    inputname.setText("");
                    inputtitle.setText("");
                    inputmail.setText("");
                    inputcomment.setText("");
                    break;
                case R.id.btConfirm:
                    dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");

            }

        }
    }
}