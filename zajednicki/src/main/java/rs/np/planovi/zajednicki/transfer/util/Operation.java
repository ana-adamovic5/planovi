/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.transfer.util;

/**
 * Predstavlja popis sistemskih operacija u vidu konstanti koje se pozivaju pri
 * slanju klijentskih zahteva ka serveru. Klasa definise 18 sistemskih
 * operacija.
 *
 * @author Ana Adamovic
 */
public interface Operation {

    /**
     * Konstanta operacije za prijavljivanje korisnika na sistem kao ceo broj.
     */
    public static final int LOGIN = 0;

    /**
     * Konstanta operacije koja vraca sve korisnike iz baze kao ceo broj.
     */
    public static final int GET_ALL_KORISNIK = 1;

    /**
     * Konstanta operacije koja kreira novi cilj u bazi kao ceo broj.
     */
    public static final int ADD_CILJ = 2;

    /**
     * Konstanta operacije koja brise cilj iz baze kao ceo broj.
     */
    public static final int DELETE_CILJ = 3;

    /**
     * Konstanta operacije koja menja cilj u bazi kao ceo broj.
     */
    public static final int UPDATE_CILJ = 4;
    /**
     * Konstanta operacije koja vraca sve ciljeve iz baze kao ceo broj.
     */
    public static final int GET_ALL_CILJ = 5;

    /**
     * Konstanta operacije koja kreira novi nedeljni plan u bazi kao ceo broj.
     */
    public static final int ADD_NEDELJNI_PLAN = 6;

    /**
     * Konstanta operacije koja brise nedeljni plan iz baze kao ceo broj.
     */
    public static final int DELETE_NEDELJNI_PLAN = 7;

    /**
     * Konstanta operacije koja menja nedeljni plan u bazi kao ceo broj.
     */
    public static final int UPDATE_NEDELJNI_PLAN = 8;
    
    /**
     * Konstanta operacije koja vraca sve nedeljne planove iz baze kao ceo broj.
     */
    public static final int GET_ALL_NEDELJNI_PLAN = 9;

    /**
     * Konstanta operacije koja vraca sve dnevne aktivnosti iz baze kao ceo
     * broj.
     */
    public static final int GET_ALL_DNEVNA_AKTIVNOST = 10;

    /**
     * Konstanta operacije koja vraca sve aktivnosti iz baze kao ceo broj.
     */
    public static final int GET_ALL_AKTIVNOST = 11;

    /**
     * Konstanta operacije koja vraca sve tipove aktivnosti iz baze kao ceo
     * broj.
     */
    public static final int GET_ALL_TIP_AKTIVNOSTI = 12;

    /**
     * Konstanta operacije koja vraca sve kategorije ciljeva iz baze kao ceo
     * broj.
     */
    public static final int GET_ALL_KATEGORIJE = 13;

    /**
     * Konstanta operacije koja kreira novu belesku u bazi kao ceo broj.
     */
    public static final int ADD_BELESKA = 14;

    /**
     * Konstanta operacije koja brise beleske iz baze kao ceo broj.
     */
    public static final int DELETE_BELESKA = 15;

    /**
     * Konstanta operacije koja menja belesku u bazi kao ceo broj.
     */
    public static final int UPDATE_BELESKA = 16;

    /**
     * Konstanta operacije koja vraca sve beleske iz baze kao ceo broj.
     */
    public static final int GET_ALL_BELESKA = 17;

}
