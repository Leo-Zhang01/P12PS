package sg.edu.rp.c346.p12ps;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnniversaryFragment extends Fragment {
    Button btnEdit;
    TextView textView;

    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_anniversary, container, false);

        btnEdit = v.findViewById(R.id.btnEdit);
        textView = v.findViewById(R.id.textView2);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        textView.setText(prefs.getString("annFrag",""));
        Log.i("sharepre","get data: "+prefs.getString("annFrag",""));
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater1 = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase =
                        (LinearLayout) inflater1.inflate(R.layout.edit_text, null);
                final EditText etPassphrase = (EditText) passPhrase.findViewById(R.id.editText);
                builder.setTitle("Enter sth")
                        .setView(passPhrase)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String result = etPassphrase.getText().toString().trim();
                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                SharedPreferences.Editor preEdit = prefs.edit();
                                preEdit.putString("annFrag", result);
                                preEdit.commit();
                                textView.setText(result);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        return v;
    }

}
