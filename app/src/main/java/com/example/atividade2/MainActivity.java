    package com.example.atividade2;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        double vtaca, vprato, vgarfo, vfaca, vtotal;
        EditText et_taca, et_prato, et_garfo, et_faca;
        CheckBox cb_taca, cb_garfo, cb_prato, cb_faca;
        TextView tv_resultado;
        Button btn_calcular;



        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            et_taca = findViewById(R.id.et_tacas);
            et_prato = findViewById(R.id.et_pratos);
            et_garfo = findViewById(R.id.et_garfos);
            et_faca = findViewById(R.id.et_facas);

            cb_taca = findViewById(R.id.cb_tacas);
            cb_prato = findViewById(R.id.cb_pratos);
            cb_garfo = findViewById(R.id.cb_garfos);
            cb_faca = findViewById(R.id.cb_facas);

            btn_calcular = findViewById(R.id.btn_Calcular);

            tv_resultado = findViewById(R.id.tv_resultado);

            vtaca = 0.25;
            vprato = 0.20;
            vgarfo = 0.15;
            vfaca = 0.15;
            vtotal = 0.0;

            cb_taca.setText(cb_taca.getText().toString() + vtaca);
            cb_prato.setText(cb_prato.getText().toString() + vprato);
            cb_garfo.setText(cb_garfo.getText().toString() + vgarfo);
            cb_faca.setText(cb_faca.getText().toString() + vfaca);

            }

            public void  Calcular(View v){
                vtotal = 0.0;

                if(cb_taca.isChecked() && et_taca.getText().length() > 0){
                    vtotal = vtaca * Double.parseDouble(et_taca.getText().toString());
                }
                if(cb_prato.isChecked() && et_prato.getText().length() > 0){
                    vtotal += vprato * Double.parseDouble(et_prato.getText().toString());
                }
                if(cb_garfo.isChecked() && et_garfo.getText().length() > 0){
                    vtotal += vgarfo * Double.parseDouble(et_garfo.getText().toString());
                }
                if(cb_faca.isChecked() && et_faca.getText().length() > 0){
                    vtotal += vfaca * Double.parseDouble(et_faca.getText().toString());
                }
                tv_resultado.setText("Valor total: R$: " + vtotal);

                AlertDialog.Builder cxMsg = new AlertDialog.Builder(this);
                cxMsg.setMessage("Valor da locação: R$" + vtotal);
                cxMsg.setNeutralButton("Ok", null);
                cxMsg.show();
                //Toast.makeText(this, "Valor da locação calculada", Toast.LENGTH_SHORT).show();
            }

            public void abrirTelaSobre(View v){
                Intent intent = new Intent(this, tela_sobre.class);
                startActivity(intent);
//                setContentView(R.layout.activity_tela_sobre);
            }



    }