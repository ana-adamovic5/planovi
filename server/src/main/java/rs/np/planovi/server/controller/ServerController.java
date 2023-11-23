/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.controller;

import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;
import rs.np.planovi.zajednicki.domain.Korisnik;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import rs.np.planovi.zajednicki.domain.TipAktivnosti;
import java.util.ArrayList;
import rs.np.planovi.server.so.aktivnost.SOGetAllAktivnost;
import rs.np.planovi.server.so.beleska.SOAddBeleska;
import rs.np.planovi.server.so.beleska.SODeleteBeleska;
import rs.np.planovi.server.so.beleska.SOGetAllBeleska;
import rs.np.planovi.server.so.beleska.SOUpdateBeleska;
import rs.np.planovi.server.so.cilj.SOAddCilj;
import rs.np.planovi.server.so.cilj.SODeleteCilj;
import rs.np.planovi.server.so.cilj.SOGetAllCilj;
import rs.np.planovi.server.so.cilj.SOUpdateCilj;
import rs.np.planovi.server.so.dnevnaAktivnost.SOGetAllDnevnaAktivnost;
import rs.np.planovi.server.so.korisnik.SOGetAllKorisnik;
import rs.np.planovi.server.so.login.SOLogin;
import rs.np.planovi.server.so.nedeljniPlan.SOAddNedeljniPlan;
import rs.np.planovi.server.so.nedeljniPlan.SODeleteNedeljniPlan;
import rs.np.planovi.server.so.nedeljniPlan.SOGetAllNedeljniPlan;
import rs.np.planovi.server.so.nedeljniPlan.SOUpdateNedeljniPlan;
import rs.np.planovi.server.so.tipAktivnosti.SOGetAllTipAktivnosti;
import rs.np.planovi.server.so.kategorijaCilja.SOGetAllKategorijaCilja;

/**
 * Serverski korntroler je klasa koja upravlja poslovnim logikama servera.
 *
 * @author Ana Adamovic
 */
public class ServerController {

    /**
     * Staticka instanca kontrolera.
     */
    private static ServerController instance;

    /**
     * Bezparametarski konstruktor.
     */
    private ServerController() {
    }

    /**
     * Metoda koja vraca instancu kontrolera. Implementirana je kao Singleton
     * kako bi se osiguralo da postoji samo jedna instanca kontrolera.
     *
     * @return instanca kontrolera
     */
    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju prijavljivanja
     * korisnika na sistem.
     *
     * @param korisnik korisnik koji se prijavljuje na sistem
     * @return prijavljeni korisnik
     * @throws Exception ukoliko je prijavljeni korisnik null
     */
    public Korisnik login(Korisnik korisnik) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(korisnik);
        return so.getUlogovani();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju dodavanja cilja.
     *
     * @param cilj cilj koji se dodaje u bazu
     * @throws Exception ukoliko cilj nije uspesno dodat u bazu
     */
    public void addCilj(Cilj cilj) throws Exception {
        (new SOAddCilj()).templateExecute(cilj);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju dodavanja beleske.
     *
     * @param beleska beleska koji se dodaje u bazu
     * @throws Exception ukoliko beleska nije uspesno dodata u bazu
     */
    public void addBeleska(Beleska beleska) throws Exception {
        (new SOAddBeleska()).templateExecute(beleska);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju dodavanja nedeljnog
     * plana.
     *
     * @param nedeljniPlan nedeljni plan koji se dodaje u bazu
     * @throws Exception ukoliko nedeljni plan nije uspesno dodat u bazu
     */
    public void addNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        (new SOAddNedeljniPlan()).templateExecute(nedeljniPlan);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju brisanja cilja.
     * 
     * @param cilj cilj koji se brise iz baze
     * @throws Exception ukoliko cilj nije uspesno obrisan iz baze
     */
    public void deleteCilj(Cilj cilj) throws Exception {
        (new SODeleteCilj()).templateExecute(cilj);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju brisanja beleske.
     * 
     * @param beleska beleska koja se brise iz baze
     * @throws Exception ukoliko beleska nije uspesno obrisana iz baze
     */
    public void deleteBeleska(Beleska beleska) throws Exception {
        (new SODeleteBeleska()).templateExecute(beleska);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju brisanja nedeljnog plana.
     * 
     * @param nedeljniPlan nedeljni plan koji se brise iz baze
     * @throws Exception ukoliko nedeljni plan nije uspesno obrisan iz baze
     */
    public void deleteNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        (new SODeleteNedeljniPlan()).templateExecute(nedeljniPlan);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju izmene cilja.
     * 
     * @param cilj cilj koji se menja u bazi
     * @throws Exception ukoliko cilj nije uspesno izmenjen u bazi
     */
    public void updateCilj(Cilj cilj) throws Exception {
        (new SOUpdateCilj()).templateExecute(cilj);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju izmene beleske.
     * 
     * @param beleska beleska koja se menja u bazi
     * @throws Exception ukoliko beleska nije uspesno izmenjena u bazi
     */
    public void updateBeleska(Beleska beleska) throws Exception {
        (new SOUpdateBeleska()).templateExecute(beleska);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za operaciju izmene nedeljnog plana.
     * 
     * @param nedeljniPlan nedeljni plan koji se menja u bazi
     * @throws Exception ukoliko nedeljni plan nije uspesno izmenjen u bazi
     */
    public void updateNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        (new SOUpdateNedeljniPlan()).templateExecute(nedeljniPlan);
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste korisnika.
     * @return lista objekata klase Korisnik
     * @throws Exception ukoliko ne moze da se vrati lista korisnika
     */
    public ArrayList<Korisnik> getAllKorisnik() throws Exception {
        SOGetAllKorisnik so = new SOGetAllKorisnik();
        so.templateExecute(new Korisnik());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste ciljeva.
     * @return lista objekata klase Cilj
     * @throws Exception ukoliko ne moze da se vrati lista ciljeva
     */
    public ArrayList<Cilj> getAllCilj() throws Exception {
        SOGetAllCilj so = new SOGetAllCilj();
        so.templateExecute(new Cilj());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste belezaka.
     * @return lista objekata klase Beleska
     * @throws Exception ukoliko ne moze da se vrati lista belezaka
     */
    public ArrayList<Beleska> getAllBeleska() throws Exception {
        SOGetAllBeleska so = new SOGetAllBeleska();
        so.templateExecute(new Beleska());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste nedeljnih planova.
     * @return lista objekata klase NedeljniPlan
     * @throws Exception ukoliko ne moze da se vrati lista nedeljnih planova
     */
    public ArrayList<NedeljniPlan> getAllNedeljniPlan() throws Exception {
        SOGetAllNedeljniPlan so = new SOGetAllNedeljniPlan();
        so.templateExecute(new NedeljniPlan());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste tipova aktivnosti.
     * @return lista objekata klase TipAktivnosti
     * @throws Exception ukoliko ne moze da se vrati lista tipova aktivnosti
     */
    public ArrayList<TipAktivnosti> getAllTipAktivnosti() throws Exception {
        SOGetAllTipAktivnosti so = new SOGetAllTipAktivnosti();
        so.templateExecute(new TipAktivnosti());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste kategorija ciljeva.
     * @return lista objekata klase KategorijaCilja
     * @throws Exception ukoliko ne moze da se vrati lista kategorija ciljeva
     */
    public ArrayList<KategorijaCilja> getAllKategorijaCilja() throws Exception {
        SOGetAllKategorijaCilja so = new SOGetAllKategorijaCilja();
        so.templateExecute(new KategorijaCilja());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste aktivnosti.
     * @return lista objekata klase Aktivnost
     * @throws Exception ukoliko ne moze da se vrati lista aktivnosti
     */
    public ArrayList<Aktivnost> getAllAktivnost() throws Exception {
        SOGetAllAktivnost so = new SOGetAllAktivnost();
        so.templateExecute(new Aktivnost());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste dnevnih aktivnosti.
     * @return lista objekata klase DnevnaAktivnost
     * @throws Exception ukoliko ne moze da se vrati lista dnevnih aktivnosti
     */
    public ArrayList<DnevnaAktivnost> getAllDnevnaAktivnost(NedeljniPlan np) throws Exception {
        SOGetAllDnevnaAktivnost so = new SOGetAllDnevnaAktivnost();

        DnevnaAktivnost da = new DnevnaAktivnost();
        da.setNedeljniPlan(np);

        so.templateExecute(da);
        return so.getLista();
    }

}
