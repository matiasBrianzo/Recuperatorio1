package usuario.example.recuperatorio1.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import usuario.example.recuperatorio1.R;
import usuario.example.recuperatorio1.modelo.Pelicula;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.viewHolder>{

    private List<Pelicula> peliculaList;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public PeliculaAdapter(List<Pelicula> peliculaList, Context context, LayoutInflater inflater) {
        this.peliculaList = peliculaList;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_pelicula,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.titulo.setText(peliculaList.get(position).getTitulo());
        holder.director.setText(peliculaList.get(position).getDirector()+"");
    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }
    public interface OnItemClickListener {
        void onItemClick(Pelicula position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, director;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.tvTitulo);
            director=itemView.findViewById(R.id.tvDirector);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(peliculaList.get(position));

                        }
                    }

                }
            });

        }
    }
}
