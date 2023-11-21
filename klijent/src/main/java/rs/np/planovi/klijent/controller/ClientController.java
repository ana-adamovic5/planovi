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
 *
 * @author adamo
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        return (Korisnik) sendRequest(Operation.LOGIN, korisnik);
    }

    public void addCilj(Cilj cilj) throws Exception {
        sendRequest(Operation.ADD_CILJ, cilj);
    }
    public void addBeleska(Beleska beleska) throws Exception {
        sendRequest(Operation.ADD_BELESKA, beleska);
    }

    public void addNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        sendRequest(Operation.ADD_NEDELJNI_PLAN, nedeljniPlan);
    }

    public void deleteCilj(Cilj cilj) throws Exception {
        sendRequest(Operation.DELETE_CILJ, cilj);
    }
    
     public void deleteBeleska(Beleska beleska) throws Exception {
        sendRequest(Operation.DELETE_BELESKA, beleska);
    }

    public void deleteNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        sendRequest(Operation.DELETE_NEDELJNI_PLAN, nedeljniPlan);
    }

    public void updateCilj(Cilj cilj) throws Exception {
        sendRequest(Operation.UPDATE_CILJ, cilj);
    }
    
     public void updateBeleska(Beleska beleska) throws Exception {
        sendRequest(Operation.UPDATE_BELESKA, beleska);
    }

    public void updateNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        sendRequest(Operation.UPDATE_NEDELJNI_PLAN, nedeljniPlan);
    }

    public ArrayList<Korisnik> getAllKorisnik() throws Exception {
        return (ArrayList<Korisnik>) sendRequest(Operation.GET_ALL_KORISNIK, null);
    }

     public ArrayList<Beleska> getAllBeleska() throws Exception {
        return (ArrayList<Beleska>) sendRequest(Operation.GET_ALL_BELESKA, null);
    }
     
    public ArrayList<Cilj> getAllCilj() throws Exception {
        return (ArrayList<Cilj>) sendRequest(Operation.GET_ALL_CILJ, null);
    }
    
    public ArrayList<KategorijaCilja> getAllKategorijaCilja() throws Exception {
        return (ArrayList<KategorijaCilja>) sendRequest(Operation.GET_ALL_KATEGORIJE, null);
    }

    public ArrayList<NedeljniPlan> getAllNedeljniPlan() throws Exception {
        return (ArrayList<NedeljniPlan>) sendRequest(Operation.GET_ALL_NEDELJNI_PLAN, null);
    }

    public ArrayList<TipAktivnosti> getAllTipAktivnosti() throws Exception {
        return (ArrayList<TipAktivnosti>) sendRequest(Operation.GET_ALL_TIP_AKTIVNOSTI, null);
    }

    public ArrayList<Aktivnost> getAllAktivnost() throws Exception {
        return (ArrayList<Aktivnost>) sendRequest(Operation.GET_ALL_AKTIVNOST, null);
    }

    public ArrayList<DnevnaAktivnost> getAllDnevnaAktivnost(NedeljniPlan np) throws Exception {
        return (ArrayList<DnevnaAktivnost>) sendRequest(Operation.GET_ALL_DNEVNA_AKTIVNOST, np);
    }

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
