package id.sc.smktelkom_mlg.tugas1.xirpl3031.tiketbioskop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama, etEmail;
    RadioButton rb21, rbXXI;
    Button bOk;
    TextView tvHasil, tvButton, tvMakanan;
    Spinner spKota, spFilm;
    CheckBox cbPC, cbS, cbSD, cbMW;
    int nMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        rb21 = (RadioButton) findViewById(R.id.rb21);
        rbXXI = (RadioButton) findViewById(R.id.rbXXI);
        spKota = (Spinner) findViewById(R.id.spinner);
        spFilm = (Spinner) findViewById(R.id.spinner2);
        cbPC = (CheckBox) findViewById(R.id.checkBoxPC);
        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        cbSD = (CheckBox) findViewById(R.id.checkBoxSD);
        cbMW = (CheckBox) findViewById(R.id.checkBoxMW);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvButton = (TextView) findViewById(R.id.textViewButton);
        tvMakanan = (TextView) findViewById(R.id.textViewMakanan);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
                doClick2();
            }
        });

        cbPC.setOnCheckedChangeListener(this);
        cbS.setOnCheckedChangeListener(this);
        cbSD.setOnCheckedChangeListener(this);
        cbMW.setOnCheckedChangeListener(this);
    }

    private void doClick2() {
        String hasil3 = "Pesanan Anda : \n";
        int starlen = hasil3.length();
        if (cbPC.isChecked()) hasil3 += cbPC.getText() + "\n";

    }

    private void doClick() {
        String hasil2 = null;

        if (rb21.isChecked()) {
            hasil2 = rb21.getText().toString();
        } else if (rbXXI.isChecked()) {
            hasil2 = rbXXI.getText().toString();
        }

        if (hasil2 == null) {
            tvButton.setText("Anda Belum Memilih Bioskop");
        } else {
            tvButton.setText("Bioskop : " + hasil2);
        }
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String email = etEmail.getText().toString();
            tvHasil.setText("Data Anda \n\n" +
                    "Nama : " + nama + "\n" +
                    "Email : " + email + "\n" +
                    "Kota : " + spKota.getSelectedItem().toString() + "\n" +
                    "Film : " + spFilm.getSelectedItem().toString() + "\n" +
                    "\nTerima Kasih Telah Berkunjung!");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Anda Isi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Emai Belum Anda Isi");
            valid = false;
        } else if (!email.matches(emailPattern)) {
            etEmail.setError("Format Email Anda Salah");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundbutton, boolean isChecked) {
        if (isChecked) nMakanan += 1;
        else nMakanan -= 1;

        tvMakanan.setText("Makanan dan Minuman Pesanan Anda (" + nMakanan + " terpilih)");


    }
}
