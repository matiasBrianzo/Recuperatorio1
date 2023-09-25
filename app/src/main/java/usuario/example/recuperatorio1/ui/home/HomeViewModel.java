package usuario.example.recuperatorio1.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import usuario.example.recuperatorio1.modelo.Pelicula;

public class HomeViewModel extends AndroidViewModel {

    private  MutableLiveData<List<Pelicula>> lstMPelicula;
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();
    }

    public  LiveData<List<Pelicula>> getListaMutable()
    {
        if (lstMPelicula== null)
        {
            lstMPelicula= new MutableLiveData<>();
        }
        return lstMPelicula;
    }

    public void armarLista()
    {
        List<Pelicula> lista= new ArrayList<>();

        lista.add(new Pelicula("Titulo: Indiana Jones","Duraccion: 150M","Director: Steven Spielberg","Año: 2023"));
        lista.add(new Pelicula("Titulo: Star Trek","Duraccion: 90M","Director: J. J. Abrams","Año: 1994"));
        lista.add(new Pelicula("Titulo: Star War","Duraccion: 60M","Director: George Lucas","Año: 2022"));

        lista.add(new Pelicula("Titulo: Indiana Jones","Duraccion: 150M","Director: Steven Spielberg","Año: 2023"));
        lista.add(new Pelicula("Titulo: Star Trek","Duraccion: 90M","Director: J. J. Abrams","Año: 1994"));
        lista.add(new Pelicula("Titulo: Star War","Duraccion: 60M","Director: George Lucas","Año: 2022"));

        lstMPelicula.setValue(lista);
    }


}