package cat.montilivi.municipis.dades;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

import cat.montilivi.municipis.R;
import cat.montilivi.municipis.models.Municipi;
import cat.montilivi.municipis.models.Provincia;


public class Fitxers {
    public static final String MUNICIPI = "Municipi";
    public static final String LIST_MUNICIPIS = "LlistaDeMunicipis";
    public static final String MAP_MUNICIPIS = "DiccionariDeMunicipis";

    public static ArrayList<Municipi> obteMunicipis(Context contexte) {
        ArrayList<Municipi> municipis = new ArrayList<Municipi>();

        try {
            String linia;
            String[] camps;
            String prefixBandera, prefixEscut;
            InputStream fitxerRaw = contexte.getResources().openRawResource(R.raw.municipis);
            BufferedReader brEntrada = new BufferedReader(new InputStreamReader(fitxerRaw));

            while ((linia = brEntrada.readLine()) != null) {
                camps = linia.split(";");
                Municipi m = new Municipi(Integer.parseInt(camps[0]), Integer.parseInt(camps[3]), camps[1], camps[2],0,0);
                //Si no existeix el recurs de bandera o escut, retorna un 0.
                prefixBandera = m.getCodiIne()<10000?"bn0":"bn";
                prefixEscut = m.getCodiIne()<10000?"ec0":"ec";
                m.setBandera(contexte.getResources().getIdentifier(prefixBandera+m.getCodiIne(),"drawable",contexte.getPackageName()));
                m.setEscut(contexte.getResources().getIdentifier(prefixEscut+m.getCodiIne(),"drawable",contexte.getPackageName()));
                if (m.getBandera()==0)
                {
                    m.setBandera(android.R.drawable.ic_delete);
                }
                if (m.getEscut()==0)
                {
                    m.setEscut(android.R.drawable.ic_delete);
                }
                municipis.add(m);
            }
            fitxerRaw.close();
        } catch (Exception ex) {
        }

        Collections.sort(municipis);
        return municipis;
    }

    public static Map<String,ArrayList<Municipi>> obteMunicipisClassificats(Context contexte)
    {
        Map<String,ArrayList<Municipi>> municipisExp= new Hashtable<String, ArrayList<Municipi>>();
        ArrayList<Municipi> municipis = Fitxers.obteMunicipis(contexte);
        for(Municipi m:municipis)
        {
            if (!municipisExp.containsKey(m.getNomProvincia())) {
                municipisExp.put(m.getNomProvincia(), new ArrayList<Municipi>());
            }

            ArrayList<Municipi> taula =  municipisExp.get(m.getNomProvincia());
            taula.add(m);
        }
        return municipisExp;
    }

    private static Integer codiProvincia (int codiINE)
    {
        Integer resultat = codiINE/1000;
        return resultat;
    }
    public static Map<Integer, String> obteTaulaProvincies (Context contexte)
    {
        Map<Integer, String> provincies = new Hashtable<Integer, String>();
        ArrayList<Municipi> municipis = Fitxers.obteMunicipis(contexte);
        for(Municipi m:municipis)
        {
            if (!provincies.containsKey(codiProvincia(m.getCodiIne()))) {
                provincies.put(codiProvincia(m.getCodiIne()), m.getNomProvincia());
            }
        }
        return provincies;
    }

    public static ArrayList<Provincia> obteTaulaNomProvincies (Context contexte)
    {
        Map<String,ArrayList<Municipi>> municipisClassificats = Fitxers.obteMunicipisClassificats(contexte);
        ArrayList<Provincia> provincies = new ArrayList<Provincia>();
        Provincia provincia;
        for(String nomProvincia : municipisClassificats.keySet())
        {
            provincia = new Provincia (municipisClassificats.get(nomProvincia).get(0).getCodiProvincia(),municipisClassificats.get(nomProvincia).get(0).getNomProvincia());
            provincies.add(provincia);
        }
        Collections.sort(provincies);
        return  provincies;
    }

}
