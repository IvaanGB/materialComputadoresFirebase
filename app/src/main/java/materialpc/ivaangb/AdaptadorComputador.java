package materialpc.ivaangb;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ivang on 29/5/2018.
 */

public class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder>{
    private ArrayList<Computador> computador;
    private OnComputadorClickListener clickListener;

    public AdaptadorComputador(ArrayList<Computador> pc, OnComputadorClickListener clickListener){
        this.computador=pc;
        this.clickListener = clickListener;
    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_computadores,parent,false);
        return new ComputadorViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador p = computador.get(position);

        holder.foto.setImageResource(p.getFoto());
        holder.marca.setText(""+p.getMarca());
        holder.tipo.setText(""+p.getTipo());
        holder.ram.setText(p.getRam());
        holder.so.setText(""+p.getSo());
        holder.color.setText(""+p.getColor());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onComputadorClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return computador.size();
    }

    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView tipo;
        private TextView ram;
        private TextView so;
        private TextView color;

        private View v;

        public ComputadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            marca = v.findViewById(R.id.lblMarca);
            tipo = v.findViewById(R.id.lblTipo);
            ram = v.findViewById(R.id.lblRam);
            so = v.findViewById(R.id.lblSO);
            color = v.findViewById(R.id.lblColor);

        }

    }

    public interface OnComputadorClickListener{
        void onComputadorClick(Computador p);
    }


}
