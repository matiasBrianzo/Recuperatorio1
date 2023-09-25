package usuario.example.recuperatorio1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import usuario.example.recuperatorio1.R;
import usuario.example.recuperatorio1.databinding.FragmentHomeBinding;
import usuario.example.recuperatorio1.modelo.Pelicula;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getListaMutable().observe(getViewLifecycleOwner(), new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {

                RecyclerView rv = binding.rvPelicula;
                GridLayoutManager glm = new GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(glm);

                PeliculaAdapter peliculaAdapter= new PeliculaAdapter(peliculas, getActivity(), getLayoutInflater());
                rv.setAdapter(peliculaAdapter);
               peliculaAdapter.setOnItemClickListener(new PeliculaAdapter.OnItemClickListener() {
                   @Override
                   public void onItemClick(Pelicula pelicula) {

                       HomeFragment f = new HomeFragment();
                       Bundle bundle = new Bundle();

                       bundle.putString("titulo", pelicula.getTitulo().toString());
                       bundle.putString("duracion", pelicula.getDuracion().toString());
                       bundle.putString("director", pelicula.getDirector().toString());
                       bundle.putString("year", pelicula.getYear().toString());

                       f.setArguments(bundle);
                       Navigation.findNavController(getView()).navigate(R.id.detallePelicula,bundle);

                   }
               });

            }
        });
        vm.armarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}