/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.transfer;

import java.io.Serializable;

/**
 * Predstavlja klijentski zahtev koji se salje serveru. Klijentski zahtev ima
 * definisanu operaciju i podatke koje prosledjuje.
 *
 * Implementira interfejs Serializable da bi objekti klase mogli da se salju preko soketa.
 * Objekat se serijalizuje u niz bitova pre slanja,
 * a zatim se deserijalizuje opet u isti objekat nakon slanja preko soketa.
 * 
 * @author Ana Adamovic
 */
public class Request implements Serializable {

    /**
     * Zahtevana operacija kao ceo broj
     */
    private int operation;

    /**
     * Podaci koji se salju kao objekat klase Object
     */
    private Object data;

    /**
     * Bezparametarski konstruktor
     */
    public Request() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za operaciju i podatke klijentskog zahteva.
     * 
     * @param operation nova vrednost za operaciju klijentskog zahteva
     * @param data nova vrednost za podatke klijentskog zahteva
     */
    public Request(int operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    /**
     * Vraca podatke klijentskog zahteva.
     *
     * @return podaci klijentskog zahteva kao objekat klase Object
     */
    public Object getData() {
        return data;
    }

    /**
     * Vraca zahtevu operaciju.
     *
     * @return operacija klijentskog zahteva kao ceo broj
     */
    public int getOperation() {
        return operation;
    }

    /**
     * Postavlja vrednost atributa podaci.
     *
     * @param data podaci klijentskog zahteva kao objekat klase Object
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Postavlja vrednost operacije klijentskog zahteva.
     *
     * @param operation operacija klijentskog zahteva kao ceo broj
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

}
