package com.example.dell.seconddatabaseexample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Java extends Activity {

    DatabasehelperMain db;
    ProductModule pd;
    ListView listview1;
    TextView textview1;
    private ArrayList<ProductModule> list1 = new ArrayList<ProductModule>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alllayout);
        ImageView bt1 = (ImageView) findViewById(R.id.add);
        listview1 = (ListView) findViewById(R.id.listview);
        textview1 = (TextView) findViewById(R.id.textview);
        bt1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialogbox = new Dialog(Java.this);
                dialogbox.setContentView(R.layout.dialog);
                final EditText edid = (EditText) dialogbox
                        .findViewById(R.id.entryid);
                final EditText edname = (EditText) dialogbox
                        .findViewById(R.id.entryname);
                final EditText edamt = (EditText) dialogbox
                        .findViewById(R.id.entryamt);
                Button edadd = (Button) dialogbox.findViewById(R.id.addentry);
                Button edcancel = (Button) dialogbox
                        .findViewById(R.id.cancelentry);
                dialogbox.show();
                edadd.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (edid.getText().toString().length() == 0) {
                            Toast.makeText(getApplicationContext(), "INPUT ID", Toast.LENGTH_LONG).show();
                        }
                        // TODO Auto-generated method stub
                        else {
                            db = new DatabasehelperMain(getApplicationContext());
                            db.getWritableDatabase();
                            pd = new ProductModule();
                            pd.pid = (edid.getText().toString());
                            pd.pname = (edname.getText().toString());
                            pd.pamt = (edamt.getText().toString());
                            db.addInformationjava(pd);
                            Toast.makeText(getApplicationContext(),
                                    "Record Successfully Added", Toast.LENGTH_LONG)
                                    .show();
                            dialogbox.dismiss();
                            onResume();
                        }
                    }
                });
                edcancel.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialogbox.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        list1.clear();
        db = new DatabasehelperMain(getApplicationContext());
        db.getWritableDatabase();
        ArrayList<ProductModule> list11 = db.getProductsjava();
        for (int i = 0; i < list11.size(); i++) {

            String stuid = list11.get(i).getPid();
            String stuname = list11.get(i).getPname();
            String stuamt = list11.get(i).getPamt();
            ProductModule pd1 = new ProductModule();
            pd1.setPid(stuid);
            pd1.setPname(stuname);
            pd1.setPamt(stuamt);
            list1.add(pd1);
        }
        textview1.setText("Total Records: " + list1.size());
        listview1.setAdapter(new Androidview(this));
        db.close();

    }

    public class Androidview extends BaseAdapter {
        LayoutInflater inflate1;

        public Androidview(Context android) {
            // TODO Auto-generated constructor stub
            inflate1 = LayoutInflater.from(android);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list1.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup Parent) {
            // TODO Auto-generated method stub
            ViewHolder hold = null;
            if (convertView == null) {
                convertView = inflate1.inflate(R.layout.listrecords, null);
                hold = new ViewHolder();
                hold.STUDENTID = (TextView) convertView.findViewById(R.id.idd);
                hold.STUDENTNAME = (TextView) convertView
                        .findViewById(R.id.name);
                hold.PAIDAMOUNT = (TextView) convertView
                        .findViewById(R.id.paid);
                convertView.setTag(hold);

            } else {
                hold = (ViewHolder) convertView.getTag();
            }

            hold.STUDENTID.setText(list1.get(position).getPid());
            hold.STUDENTNAME.setText(list1.get(position).getPname());
            hold.PAIDAMOUNT.setText(list1.get(position).getPamt());
            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    final Dialog dialogbox1 = new Dialog(Java.this);
                    dialogbox1.setContentView(R.layout.update);

                    final EditText updatename1 = (EditText) dialogbox1
                            .findViewById(R.id.updatename);
                    final EditText updateamt1 = (EditText) dialogbox1
                            .findViewById(R.id.updateamt);
                    Button updateall = (Button) dialogbox1
                            .findViewById(R.id.update1);
                    Button deleteall = (Button) dialogbox1
                            .findViewById(R.id.delete1);
                    Button cancelall = (Button) dialogbox1
                            .findViewById(R.id.cancel1);
                    dialogbox1.show();
                    updateall.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            db = new DatabasehelperMain(getApplicationContext());
                            db.getWritableDatabase();
                            ProductModule pp = new ProductModule();
                            // pp.pid = updateid1.getText().toString();
                            /*
							 * gets updatename1 from user,converts to string and
							 * passes to pp.pname
							 */
                            if (updatename1.getText().toString().length() == 0 || updateamt1.getText().toString().length() == 0) {

                                Toast.makeText(getApplicationContext(), "Input name and paid", Toast.LENGTH_LONG).show();

                            } else {
                                pp.pname = updatename1.getText().toString();
                                pp.pamt = updateamt1.getText().toString();

                                pp.pid = (list1.get(position).getPid().toString());

                                db.Updatejava(pp);
                                db.close();
                                Java.this.onResume();
                                dialogbox1.dismiss();
                            }

                        }
                    });
                    deleteall.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            db.Removejava(list1.get(position).getPid()
                                    .toString());
                            Java.this.onResume();
                            dialogbox1.dismiss();

                        }
                    });
                    cancelall.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialogbox1.dismiss();

                        }
                    });

                }
            });

            return convertView;
        }

    }

    public class ViewHolder {
        TextView STUDENTID, STUDENTNAME, PAIDAMOUNT;
    }
}

