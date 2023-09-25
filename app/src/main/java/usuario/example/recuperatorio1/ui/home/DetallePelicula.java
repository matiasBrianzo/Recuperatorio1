package usuario.example.recuperatorio1.ui.home;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import usuario.example.recuperatorio1.R;
import usuario.example.recuperatorio1.databinding.FragmentDetallePeliculaBinding;
import usuario.example.recuperatorio1.modelo.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallePelicula#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallePelicula extends Fragment {


    private FragmentDetallePeliculaBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallePeliculaBinding.inflate(inflater, container, false);
         View root = binding.getRoot();



       Bundle bundle = getArguments();
        binding.tvtitulo.setText(bundle.getString("titulo"));
        binding.tvduracion.setText(bundle.getString("duracion"));
        binding.tvdirector.setText(bundle.getString("director"));
        binding.tvyear.setText(bundle.getString("year"));

        return root;
    }


}