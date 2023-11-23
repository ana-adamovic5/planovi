/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja apstraktnu opstu domensku klasu. Sadrzi apstraktne metode koje
 * svaka pojedinacna domenska klasa implementira.
 * 
 * Implementira interfejs Serializable da bi objekti koji nasledjuju opstu 
 * domensku klasu mogli da se salju preko soketa. Objekat se serijalizuje u niz bitova pre slanja,
 * a zatim se deserijalizuje opet u isti objekat nakon slanja preko soketa.
 *
 * @author Ana Adamovic
 *
 */
public abstract class AbstractDomainObject implements Serializable {

    /**
     * Vraca naziv tabele u bazi za odgovarajuci domenski objekat.
     *
     * @return naziv tabele kao String
     */
    public abstract String nazivTabele();

    /**
     * Vraca naziv alijasa tabele u bazi za odgovarajuci domenski objekat.
     *
     * @return alijas tabele kao String
     */
    public abstract String alijas();

    /**
     * Vraca SQL naredbu za operaciju join za odgovarajuci domenski objekat
     * ukoliko ima definisan spoljni kljuc, u suprotnom vraca prazan String.
     *
     * @return SQL naredba kao String
     */
    public abstract String join();

    /**
     * Vraca listu domenskog objekta. 
     *
     * @return lista domenskog objekta
     * @param rs tabela kao rezultat SQL upita
     *
     * @throws SQLException ukoliko sintaksta SQL upita nije ispravna
     */
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;

    /**
     * Vraca nazive kolona tabele domenskog objekta koje se ubacuju u SQL
     * naredbu za operaciju insert.
     *
     * @return nazivi kolona kao String
     */
    public abstract String koloneZaInsert();

    /**
     * Vraca vrednost primarnog kljuca.
     *
     * @return primarni kljuc kao String
     */
    public abstract String vrednostZaPrimarniKljuc();
    
    /**
     * Vraca vrednosti kolona tabele domenskog objekta koje se ubacuju u SQL
     * naredbu za operaciju insert.
     *
     * @return vrednosti atributa kao String
     */
    public abstract String vrednostiZaInsert();
    
    /**
     * Vraca vrednosti kolona tabele domenskog objekta koje se ubacuju u SQL
     * naredbu za operaciju update.
     *
     * @return vrednosti atributa kao String
     */
    public abstract String vrednostiZaUpdate();
    
    /**
     * Vraca SQL naredbu ukoliko je potreban dodatan uslov za odgovarajuci
     * domenski objekat, u suprotnom vraca prazan String.
     *
     * @return uslov kao String
     */
    public abstract String uslov();

}
