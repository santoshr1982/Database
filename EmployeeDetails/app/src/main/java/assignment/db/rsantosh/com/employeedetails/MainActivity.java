package assignment.db.rsantosh.com.employeedetails;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import assignment.db.rsantosh.com.employeedetails.DBHelper.DbHelper;
import assignment.db.rsantosh.com.employeedetails.Model.EmployeeDetails;

public class MainActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mAge;
    private ImageView mImageView;
    private DbHelper mDbHelper;

    private ArrayList<EmployeeDetails> mEmployeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (TextView) findViewById(R.id.db_name);
        mAge = (TextView) findViewById(R.id.db_age);
        mImageView = (ImageView) findViewById(R.id.emp_photo);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.emp);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] img = bos.toByteArray();

        mDbHelper = new DbHelper(getApplicationContext());
        mDbHelper.insert("Venkat","25",img);
        mEmployeeDetails = mDbHelper.getAll();

        for(EmployeeDetails employeeDetails:mEmployeeDetails){

            mName.setText(employeeDetails.getStrName());
            mAge.setText(employeeDetails.getStrAge());
            Bitmap b1=BitmapFactory.decodeByteArray(employeeDetails.getbImage(), 0, employeeDetails.getbImage().length);
            mImageView.setImageBitmap(b1);

        }

    }
}
