package com.example.dell.expensemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class Backup extends Fragment {
    DatabaseHelper databaseHelper=new DatabaseHelper(getContext());
    Button Backup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.backup, container, false);
        Backup =(Button) rootView.findViewById(R.id.Backup);
        Backup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            exportDB(getContext());
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

    public void exportDB(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
                String path= databaseHelper.getDatabaseName();
            if (sd.canWrite()) {
                String backupDBPath = String.format("%s.bak",databaseHelper.getDatabaseName());
                File currentDB = context.getDatabasePath(databaseHelper.getDatabaseName());
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getContext(), "Backup Successful!",
                        Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {

            Toast.makeText(getContext(), "Backup Failed!", Toast.LENGTH_SHORT)
                    .show();

        }
    }
}