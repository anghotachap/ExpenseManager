package com.example.dell.expensemanager;
import com.example.dell.expensemanager.DatabaseHelper;
import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class BackupAndRestore extends AppCompatActivity {
   DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
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
                Toast.makeText(getApplicationContext(), "Import Successful!",
                        Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Import Failed!", Toast.LENGTH_SHORT)
                    .show();

        }
    }

    public void exportDB(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String backupDBPath = String.format("%s.bak",databaseHelper.getDatabaseName());
                File currentDB = context.getDatabasePath(databaseHelper.getDatabaseName());
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getApplicationContext(), "Backup Successful!",
                        Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Backup Failed!", Toast.LENGTH_SHORT)
                    .show();

        }
    }
}