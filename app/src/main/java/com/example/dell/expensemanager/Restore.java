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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;


public class Restore extends Fragment {

    DatabaseHelper databaseHelper=new DatabaseHelper(getContext());
    Button Restore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restore, container, false);
        Restore =(Button) rootView.findViewById(R.id.Restore);
        Restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             importDB(getContext());
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

    public void importDB(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            if (sd.canWrite()) {
                File backupDB = context.getDatabasePath(databaseHelper.getDatabaseName());
                String backupDBPath = String.format("%s.bak",databaseHelper.getDatabaseName());
                File currentDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(backupDB).getChannel();
                FileChannel dst = new FileOutputStream(currentDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getContext(), "Import Successful!",
                        Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {

            Toast.makeText(getContext(), "Import Failed!", Toast.LENGTH_SHORT)
                    .show();

        }
    }
}