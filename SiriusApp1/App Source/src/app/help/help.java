package app.help;
 
import exam.project.R;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class help extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        
        //---------------------------------------------------
        
        ListView listViewExample = (ListView)findViewById(R.id.listViewExample);
        ArrayAdapter<CharSequence> adapterOfListViewExample = ArrayAdapter.createFromResource(
           this,
           R.array.str_languages,
           android.R.layout.simple_list_item_1);
        listViewExample.setAdapter(adapterOfListViewExample);
        listViewExample.setOnItemClickListener(itemClickListenerOfLanguageList);
    }
    
    private OnItemClickListener itemClickListenerOfLanguageList = new OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> adapterView, View clickedView, int pos, long id)
        {
            String toastMessage = ((TextView)clickedView).getText().toString() + " is selected.";
            Toast.makeText(
                getApplicationContext(),
                toastMessage,
                Toast.LENGTH_SHORT
            ).show();
        }
    };
}
