/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.transfer;

import java.io.Serializable;
import rs.np.planovi.zajednicki.transfer.util.ResponseStatus;

/**
 * Predstavlja serverski odgovor koji se salje klijentu. Serverski odgovor ima
 * definisane podatke koje salje, izuzetak i status odgovora.
 *
 * Implementira interfejs Serializable da bi objekti klase mogli da se salju
 * preko soketa. Objekat se serijalizuje u niz bitova pre slanja, a zatim se
 * deserijalizuje opet u isti objekat nakon slanja preko soketa.
 *
 * @author Ana Adamovic
 */
public class Response implements Serializable {

    /**
     * Podaci koji se salju kao objekat klase Object.
     */
    private Object data;

    /**
     * Izuzetak koji nastaje pri serverkom odgovoru kao objekat klase Exception.
     */
    private Exception exc;

    /**
     * Status serverskog odgovora koji moze biti Succes ili Error, instanca
     * enuma ResponseStatus.
     */
    private ResponseStatus responseStatus;

    /**
     * Bezparametarski konstruktor
     */
    public Response() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za podatke, izuzetak i
     * status odgovora.
     *
     * @param data nova vrednost za podatke serverskog odgovora
     * @param exc nova vrednost za izuzetak serverskog odgovora
     * @param responseStatus nova vrednost za status odgovora serverskog
     * odgovora
     */
    public Response(Object data, Exception exc, ResponseStatus responseStatus) {
        this.data = data;
        this.exc = exc;
        this.responseStatus = responseStatus;
    }

    /**
     * Vraca podatke serverskog odgovora.
     *
     * @return podaci serverskog odgovora kao objekat klase Object
     */
    public Object getData() {
        return data;
    }

    /**
     * Postavlja vrednost atributa podaci.
     *
     * @param data podaci serverskog odgovora kao objekat klase Object
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Vraca bacen izuzetak pri slanju serverskog odgovora.
     *
     * @return izuzetak kao objekat klase Exception
     */
    public Exception getException() {
        return exc;
    }

    /**
     * Postavlja vrednost atributa exception.
     *
     * @param exc izuzetak kao objekat klase Exception
     */
    public void setException(Exception exc) {
        this.exc = exc;
    }

    /**
     * Vraca status serverskog odgovora.
     *
     * @return status serverskog odgovora kao instanca enuma ResponseStatus
     */
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Postavlja vrednost statusa serverskog odgovora.
     *
     * Status moze biti Succes ili Error.
     *
     * @param responseStatus status serverskog odgovora kao instanca enuma
     * ResponseStatus
     */
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

}
