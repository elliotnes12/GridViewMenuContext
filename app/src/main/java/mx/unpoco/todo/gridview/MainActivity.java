package mx.unpoco.todo.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int contador = 0;
    private ArrayList list = new ArrayList<String>();
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("one");
        list.add("two");
        list.add("threee");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");
        list.add("twoteen");

        adapter = new MyAdapter(list,R.layout.gridtab,this);

        GridView view = (GridView) findViewById(R.id.gridview);
        view.setAdapter(adapter);

        registerForContextMenu(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                   list.add("contador -"+(++contador));
                   adapter.notifyDataSetChanged();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){

            case R.id.delete:

                this.list.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
                default:
                    return super.onContextItemSelected(item);

        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo informacion = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Elemento:"+this.list.get(informacion.position));
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
