package mx.unpoco.todo.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<String> lista;
    private int layout;
    private Context contexto;

    public MyAdapter(List<String> lista, int layout, Context contexto) {
        this.lista = lista;
        this.layout = layout;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyHolder holder;
        if(convertView == null){

            holder = new MyHolder();
            LayoutInflater inflater = LayoutInflater.from(this.contexto);
            convertView = inflater.inflate(this.layout,null);
            holder.etiqueta = convertView.findViewById(R.id.txtEtq);
            holder.etiqueta.setText(this.lista.get(position));
            convertView.setTag(holder);

        }
        else{
            holder = (MyHolder) convertView.getTag();
            holder.etiqueta.setText(this.lista.get(position));
        }

        return convertView;
    }
    static class MyHolder{
        public TextView etiqueta;
    }
}
