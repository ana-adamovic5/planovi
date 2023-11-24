/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.controller;

import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;
import rs.np.planovi.zajednicki.domain.Korisnik;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import rs.np.planovi.zajednicki.domain.TipAktivnosti;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import rs.np.planovi.klijent.session.Session;
import rs.np.planovi.zajednicki.transfer.Request;
import rs.np.planovi.zajednicki.transfer.Response;
import rs.np.planovi.zajednicki.transfer.util.ResponseStatus;
import rs.np.planovi.zajednicki.transfer.util.Operation;

/**
 * Klijentski kontroler uspostavlja vezu izmedju ekranske forme i aplikacione
 * logike. Prihvata od forme zahtev za izvrsenje sistemske operacije.
 *
 * @author Ana Adamovic
 */
public class ClientController {

    /**
     * Staticka instanca kontrolera.
     */
    private static ClientController instance;

    /**
     * Prazan konstruktor.
     */
    private ClientController() {
    }

    /**
     * Metoda koja vraca instancu klase ClientController. Implementirana je kao
     * Singleton kako bi se osiguralo da postoji samo jedna instanca klijentskog
     * kontrolera.
     *
     * @return instanca kontrolera
     */
    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    /**
     * Metoda za prijavljivanje korisnika.
     *
     * @param korisnik korisnik koji se prijavljuje na sistem
     * @return prijavljeni korisnik
     * @throws Exception ukoliko je korisnik null
     */
    public Korisnik login(Korisnik korisnik) throws Exception {
        return (Korisnik) sendRequest(Operation.LOGIN, korisnik);
    }

    /**
     * Metoda za dodavanje novog cilja.
     *
     * @param cilj novi cilj koji se dodaje u bazu
     * @throws Exception ukoliko nije cilj uspesno dodat
     */
    public void addCilj(Cilj cilj) throws Exception {
        sendRequest(Operation.ADD_CILJ, cilj);
    }

    /**
     * Metoda za dodavanje nove beleske.
     *
     * @param beleska nova beleska koji se dodaje u bazu
     * @throws Exception ukoliko nije beleska uspesno dodata
     */
    public void addBeleska(Beleska beleska) throws Exception {
        sendRequest(Operation.ADD_BELESKA, beleska);
    }

    /**
     * Metoda za dodavanje novog nedeljnog plana.
     *
     * @param nedeljniPlan novi nedeljni plan koji se dodaje u bazu
     * @throws Exception ukoliko nije nedeljni plan uspesno dodat
     */
    public void addNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        sendRequest(Operation.ADD_NEDELJNI_PLAN, nedeljniPlan);
    }

    /**
     * Metoda za brisanje cilja.
     *
     * @param cilj cilj koji se brise iz baze
     * @throws Exception ukoliko nije cilj uspesno obrisan
     */
    public void deleteCilj(Cilj cilj) throws Exception {
        sendRequest(Operation.DELETE_CILJ, cilj);
    }

    /**
     * Metoda za brisanje beleske.
     *
     * @param beleska beleska koja se brise iz baze
     * @throws Exception ukoliko nije beleska uspesno obrisana
     */
    public void deleteBeleska(Beleska beleska) throws Exception {
        sendRequest(Operation.DELETE_BELESKA, beleska);
    }

    /**
     * Metoda za brisanje nedeljnog plana.
     *
     * @param nedeljniPlan nedeljni plan koji se brise iz baze
     * @throws Exception ukoliko nije nedeljni plan uspesno obrisan
     */
    public void deleteNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        sendRequest(Operation.DELETE_NEDELJNI_PLAN, nedeljniPlan);
    }

    /**
     * Metoda za izmenu cilja.
     *
     * @param cilj cilj koji se menja u bazi
     * @throws Exception ukoliko nije cilj uspesno izmenjen
     */
    public void updateCilj(Cilj cilj) throws Exception {
        sendRequest(Operation.UPDATE_CILJ, cilj);
    }
    
    /**
     * Metoda za izmenu beleske.
     *
     * @param beleska beleska koja se menja u bazi
     * @throws Exception ukoliko nije beleska uspesno izmenjena
     */
    public void updateBeleska(Beleska beleska) throws Exception {
        sendRequest(Operation.UPDATE_BELESKA, beleska);
    }

    /**
     * Metoda za izmenu nedeljnog plana.
     *
     * @param nedeljniPlan nedeljni plan koji se menja u bazi
     * @throws Exception ukoliko nije nedeljni plan uspesno izmenjen
     */
    public void updateNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        sendRequest(Operation.UPDATE_NEDELJNI_PLAN, nedeljniPlan);
    }

    /**
     * Metoda koja vraca sve korisnike.
     *
     * @return lista svih korisnika iz baze
     * @throws Exception ukoliko ne moze da vrati listu korisnika
     */
    public ArrayList<Korisnik> getAllKorisnik() throws Exception {
        return (ArrayList<Korisnik>) sendRequest(Operation.GET_ALL_KORISNIK, null);
    }

    /**
     * Metoda koja vraca sve beleske.
     *
     * @return lista svih beleski iz baze
     * @throws Exception ukoliko ne moze da vrati listu beleski
     */
    public ArrayList<Beleska> getAllBeleska() throws Exception {
        return (ArrayList<Beleska>) sendRequest(Operation.GET_ALL_BELESKA, null);
    }

    /**
     * Metoda koja vraca sve ciljeve.
     *
     * @return lista svih ciljeva iz baze
     * @throws Exception ukoliko ne moze da vrati listu ciljeva
     */
    public ArrayList<Cilj> getAllCilj() throws Exception {
        return (ArrayList<Cilj>) sendRequest(Operation.GET_ALL_CILJ, null);
    }

    /**
     * Metoda koja vraca sve kategorije ciljeva.
     *
     * @return lista svih kategorija ciljeva iz baze
     * @throws Exception ukoliko ne moze da vrati listu ciljeva
     */
    public ArrayList<KategorijaCilja> getAllKategorijaCilja() throws Exception {
        return (ArrayList<KategorijaCilja>) sendRequest(Operation.GET_ALL_KATEGORIJE, null);
    }

    /**
     * Metoda koja vraca sve nedeljne planove.
     *
     * @return lista svih nedeljnih planova iz baze
     * @throws Exception ukoliko ne moze da vrati listu nedeljnih planova
     */
    public ArrayList<NedeljniPlan> getAllNedeljniPlan() throws Exception {
        return (ArrayList<NedeljniPlan>) sendRequest(Operation.GET_ALL_NEDELJNI_PLAN, null);
    }

    /**
     * Metoda koja vraca sve tipove aktivnosti.
     *
     * @return lista svih tipova aktivnosti iz baze
     * @throws Exception ukoliko ne moze da vrati listu tipova aktivnosti
     */
    public ArrayList<TipAktivnosti> getAllTipAktivnosti() throws Exception {
        return (ArrayList<TipAktivnosti>) sendRequest(Operation.GET_ALL_TIP_AKTIVNOSTI, null);
    }

    /**
     * Metoda koja vraca sve aktivnosti.
     *
     * @return lista svih aktivnosti iz baze
     * @throws Exception ukoliko ne moze da vrati listu aktivnosti
     */
    public ArrayList<Aktivnost> getAllAktivnost() throws Exception {
        return (ArrayList<Aktivnost>) sendRequest(Operation.GET_ALL_AKTIVNOST, null);
    }

    /**
     * Metoda koja vraca sve dnevne aktivnosti.
     *
     * @return lista svih dnevnih aktivnosti iz baze
     * @throws Exception ukoliko ne moze da vrati listu dnevnih aktivnosti
     */
    public ArrayList<DnevnaAktivnost> getAllDnevnaAktivnost(NedeljniPlan np) throws Exception {
        return (ArrayList<DnevnaAktivnost>) sendRequest(Operation.GET_ALL_DNEVNA_AKTIVNOST, np);
    }

    /**
     * Metoda salje klijentski zahtev koji treba da se obradi na serverskoj strani.
     * 
     * @param operation zahtevana sistemska operacija
     * @param data podaci koji se salju
     * @return objekat serverskog odgovora
     * @throws Exception ukoliko se ne posalje zahtev i desi se greska
     */
    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
