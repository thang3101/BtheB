package com.example.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Product;
import com.example.btheb.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Context context;

    int layout;
    List<Product> arrayList;

    public ProductAdapter(Context context, int layout, List<Product> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName;
        ImageView imvPhoto;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if ( view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.txtName=(TextView) view.findViewById(R.id.txtNameMatching);
            viewHolder.imvPhoto=(ImageView) view.findViewById(R.id.imvPhotoMatching);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtName.setText(arrayList.get(i).getName());
       byte[] photo = arrayList.get(i).getThumb();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
                 viewHolder.imvPhoto.setImageBitmap(bitmap);
        return view;
    }
}
