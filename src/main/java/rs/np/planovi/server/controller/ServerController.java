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
 *
 * @author adamo
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(korisnik);
        return so.getUlogovani();
    }

    public void addCilj(Cilj cilj) throws Exception {
        (new SOAddCilj()).templateExecute(cilj);
    }
    public void addBeleska(Beleska beleska) throws Exception {
        (new SOAddBeleska()).templateExecute(beleska);
    }

    public void addNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        (new SOAddNedeljniPlan()).templateExecute(nedeljniPlan);
    }

    public void deleteCilj(Cilj cilj) throws Exception {
        (new SODeleteCilj()).templateExecute(cilj);
    }
     public void deleteBeleska(Beleska beleska) throws Exception {
        (new SODeleteBeleska()).templateExecute(beleska);
    }

    public void deleteNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        (new SODeleteNedeljniPlan()).templateExecute(nedeljniPlan);
    }

    public void updateCilj(Cilj cilj) throws Exception {
        (new SOUpdateCilj()).templateExecute(cilj);
    }
    
    public void updateBeleska(Beleska beleska) throws Exception {
        (new SOUpdateBeleska()).templateExecute(beleska);
    }

    public void updateNedeljniPlan(NedeljniPlan nedeljniPlan) throws Exception {
        (new SOUpdateNedeljniPlan()).templateExecute(nedeljniPlan);
    }

    public ArrayList<Korisnik> getAllKorisnik() throws Exception {
        SOGetAllKorisnik so = new SOGetAllKorisnik();
        so.templateExecute(new Korisnik());
        return so.getLista();
    }

    public ArrayList<Cilj> getAllCilj() throws Exception {
        SOGetAllCilj so = new SOGetAllCilj();
        so.templateExecute(new Cilj());
        return so.getLista();
    }
    
    public ArrayList<Beleska> getAllBeleska() throws Exception {
        SOGetAllBeleska so = new SOGetAllBeleska();
        so.templateExecute(new Beleska());
        return so.getLista();
    }

    public ArrayList<NedeljniPlan> getAllNedeljniPlan() throws Exception {
        SOGetAllNedeljniPlan so = new SOGetAllNedeljniPlan();
        so.templateExecute(new NedeljniPlan());
        return so.getLista();
    }

    public ArrayList<TipAktivnosti> getAllTipAktivnosti() throws Exception {
        SOGetAllTipAktivnosti so = new SOGetAllTipAktivnosti();
        so.templateExecute(new TipAktivnosti());
        return so.getLista();
    }
    
     public ArrayList<KategorijaCilja> getAllKategorijaCilja() throws Exception {
        SOGetAllKategorijaCilja so = new SOGetAllKategorijaCilja();
        so.templateExecute(new KategorijaCilja());
        return so.getLista();
    }

    public ArrayList<Aktivnost> getAllAktivnost() throws Exception {
        SOGetAllAktivnost so = new SOGetAllAktivnost();
        so.templateExecute(new Aktivnost());
        return so.getLista();
    }

    public ArrayList<DnevnaAktivnost> getAllDnevnaAktivnost(NedeljniPlan np) throws Exception {
        SOGetAllDnevnaAktivnost so = new SOGetAllDnevnaAktivnost();
        
        DnevnaAktivnost da = new DnevnaAktivnost();
        da.setNedeljniPlan(np);
        
        so.templateExecute(da);
        return so.getLista();
    }

}
