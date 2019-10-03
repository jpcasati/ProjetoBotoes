package br.edu.mouralacerda.projetobotoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener,
        View.OnLongClickListener {

    Button b1;
    Button b2;
    Button b3;
    Button b4;

    ImageButton bike;

    ToggleButton semaforo;

    Switch bikeFuncionando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        bike = findViewById(R.id.btnBike);
        semaforo = findViewById(R.id.btnLigar);
        bikeFuncionando = findViewById(R.id.swiBikeBoa);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        findViewById(R.id.btnFechar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirMensagem("B3");
            }
        });

        b4.setOnLongClickListener(this);
        b4.setOnClickListener(this);

        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(semaforo.isChecked() && bikeFuncionando.isChecked())
                    exibirMensagem("Andando de Bike...");
                else
                    exibirMensagem("Parado...");
            }
        });

        semaforo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    exibirMensagem("Semáforo Aberto!");
                } else {
                    exibirMensagem("Semáforo Fechado!");
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btn1: {
                exibirMensagem("B1");
                break;
            }
            case R.id.btn2: {
                exibirMensagem("B2");
                break;
            }
            case R.id.btn4: {
                exibirMensagem("B4");
                break;
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        exibirMensagem("B4 LONG");
        return false;
    }



    private void exibirMensagem(String botao) {
        Toast.makeText(this,
                "Botão acionado: "+botao,
                Toast.LENGTH_SHORT).show();
    }
}
