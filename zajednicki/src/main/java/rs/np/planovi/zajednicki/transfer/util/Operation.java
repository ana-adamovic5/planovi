/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.transfer.util;

/**
 *
 * @author adamo
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int GET_ALL_KORISNIK = 1;

    public static final int ADD_CILJ = 2;
    public static final int DELETE_CILJ = 3;
    public static final int UPDATE_CILJ = 4;
    public static final int GET_ALL_CILJ = 5;

    public static final int ADD_NEDELJNI_PLAN = 6;
    public static final int DELETE_NEDELJNI_PLAN = 7;
    public static final int UPDATE_NEDELJNI_PLAN = 8;
    public static final int GET_ALL_NEDELJNI_PLAN = 9;

    public static final int GET_ALL_DNEVNA_AKTIVNOST = 10;

    public static final int GET_ALL_AKTIVNOST = 11;

    public static final int GET_ALL_TIP_AKTIVNOSTI = 12;
    
    public static final int GET_ALL_KATEGORIJE=13;
    
    public static final int ADD_BELESKA = 14;
    public static final int DELETE_BELESKA = 15;
    public static final int UPDATE_BELESKA = 16;
    public static final int GET_ALL_BELESKA = 17;
    

}
