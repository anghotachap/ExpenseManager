package com.example.dell.expensemanager;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.itextpdf.text.pdf.BaseFont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Report extends Fragment {
    private static final String LOG_TAG = "GeneratePDF";

Button PDF;
    private BaseFont bfBold;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pdfreport, container, false);
       PDF =(Button)rootView.findViewById(R.id.PDF);
       PDF.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               GeneratePDF(v);
           }
       });
        return rootView;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Day");
    }

    public void GeneratePDF(View view)
    {
        // TODO Auto-generated method stub
        String filename = "david";
        String filecontent = "Contenido";
        Metodos fop = new Metodos();
        if (fop.write(filename, filecontent)) {
            Toast.makeText(getContext(),
                    filename + ".pdf created", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(getContext(), "I/O error",
                    Toast.LENGTH_SHORT).show();
        }
    }

}