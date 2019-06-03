package mainactivity.musicplayer.example.com.pleyradio;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainactivity.musicplayer.example.com.pleyradio.Intenty.ActivitiTo;

public class Aaptar extends RecyclerView.Adapter<ClicVievHolder>{

    private Context mContext;
    private String[] mList;

    public Aaptar (Context contexts, String[] list) {
        this.mContext = contexts;
        this.mList = list;
    }

    @NonNull
    @Override
    public ClicVievHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
       View view = layoutInflater.inflate(R.layout.item_clic, viewGroup, false);
       return new ClicVievHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClicVievHolder clicVievHolder, int position) {
        clicVievHolder.textView.setText(mList[position]);
        clicVievHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Context context = view.getContext();
                Intent intent = new Intent(context, ActivitiTo.class);
                context.startActivity(intent);
            }
        });


       switch (position){
           case 0:
               clicVievHolder.setImage(R.drawable.macrisift_ofes);
               clicVievHolder.setTatel("Microsoft");
               break;
           case 1:
               clicVievHolder.setImage(R.drawable.point);
               clicVievHolder.setTatel("Point");
               break;
           case 2:
               clicVievHolder.setImage(R.drawable.drave);
               clicVievHolder.setTatel("Drave");
               break;
           case 3:
               clicVievHolder.setImage(R.drawable.cop);
               clicVievHolder.setTatel("Cortana");
               break;
           case 4:
               clicVievHolder.setImage(R.drawable.xcel);
               clicVievHolder.setTatel("Excel");
               break;
           case 5:
               clicVievHolder.setImage(R.drawable.hreni_cacaata);
               clicVievHolder.setTatel("Name");
               break;
           case 6:
               clicVievHolder.setImage(R.drawable.macrisift_ofes);
               clicVievHolder.setTatel("Macrisift");
               break;
           case 7:
               clicVievHolder.setImage(R.drawable.voskl);
               clicVievHolder.setTatel("Info");
               break;
           case 8:
               clicVievHolder.setImage(R.drawable.xbox);
               clicVievHolder.setTatel("Xbox");
               break;
               default:
       }

    }

    @Override
    public int getItemCount() {
        return mList.length;
    }
}

