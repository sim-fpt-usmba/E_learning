package ma.ac.usmba.fpt.e_learning.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

import ma.ac.usmba.fpt.e_learning.R;
import ma.ac.usmba.fpt.e_learning.Utils.FileUtils;

public class ProfContenuFilesAdapter extends RecyclerView.Adapter<ProfContenuFilesAdapter.ViewHolder> {
    Context context;
    ArrayList<String> filenames;

    public ProfContenuFilesAdapter(Context context,ArrayList<String> filenames) {
        this.context = context;
        this.filenames = filenames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_files,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String filename = filenames.get(position);
        holder.filename.setText(FileUtils.getFileName(filename));
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do Something
                //TODO: La partie de backend / Telechargement des fichiers
            }
        });
    }

    @Override
    public int getItemCount() {
        return filenames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView filename;
        Button download;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filename = itemView.findViewById(R.id.path_textview);
            download   = itemView.findViewById(R.id.download_button);
        }
    }
}
