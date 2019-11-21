package com.example.ghassen.finag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ghassen.finag.Entities.User;


public class Profil extends Fragment {

    TextView firstname,lastname,email,mathpro,fenchpro,englishpro,qipro,alpro,audiopro;
    public Profil() {
        // Required empty public constructor
    }



    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        firstname = view.findViewById(R.id.prenom);
        lastname = view.findViewById(R.id.nom);
        email = view.findViewById(R.id.mail);
        mathpro = view.findViewById(R.id.mathp);
        fenchpro = view.findViewById(R.id.frenchp);
        englishpro = view.findViewById(R.id.englishp);
        qipro = view.findViewById(R.id.qip);
        alpro = view.findViewById(R.id.alp);
        audiopro = view.findViewById(R.id.audiop);



        firstname.setText("First name: "+User.prenom);
        lastname.setText("Last name: "+User.nom);
        email.setText("Mail: "+User.mail);
        mathpro.setText("Math: "+String.valueOf(User.scoremath));
        fenchpro.setText("French: "+String.valueOf(User.scorefrench));
        englishpro.setText("English: "+String.valueOf(User.scoreenglish));
        qipro.setText("Qi: "+String.valueOf(User.scoreqi));
        alpro.setText("Alphabet: "+String.valueOf(User.scoreal));
        audiopro.setText("Audio: "+String.valueOf(User.scoreaudio));

        return  view;
    }


}
