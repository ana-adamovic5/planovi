/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.db;

import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja brokera za pristup bazi podataka.
 *
 * @author Ana Adamovic
 */
public class DBBroker {

    /**
     * Staticka instanca brokera baze podataka.
     */
    private static DBBroker instance;

    /**
     * Instanca klase Connection.
     */
    private Connection connection;

    /**
     * Konstruktor za otvaranje konekcije sa bazom podataka.
     */
    private DBBroker() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/planoviproba", "root", "");
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metoda koja vraca instancu klase Connection.
     *
     * @return instanca klase Connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Metoda koja vraca instancu klase DBBroker. Implementirana je kao
     * Singleton kako bi se osiguralo da postoji samo jedna instanca brokera
     * baze.
     *
     * @return instanca klase DBBroker
     */
    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    /**
     * Metoda koja vraca listu objekata iz baze podataka.
     * @param ado Objekat klase AbstractDomainObject cija se lista vraca iz baze podataka
     * @return lista objekata klase AbstractDomainObject
     * @throws SQLException ukoliko se ne uspostavi konekcija sa bazom podataka
     */
    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.join() + " " + ado.uslov();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }

    /**
     * Metoda koja cuva objekte u bazi podataka.
     * @param ado objekat klase AbstractDomainObject koji se dodaje u bazu podataka
     * @return identifikator novog objekta u bazi
     * @throws SQLException ukoliko se ne uspostavi konekcija sa bazom podataka
     */
    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    /**
     * Metoda za izmenu objekta u bazi podataka.
     * @param ado objekat klase AbstractDomainObject koji se menja u bazi podataka
     * @throws SQLException ukoliko se ne uspostavi konekcija sa bazom podataka
     */
    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    /**
     * Metoda koja brise objekte iz baze podataka.
     * @param ado objekat klase AbstractDomainObject koji se brise iz baze podataka
     * @throws SQLException ukoliko se ne uspostavi konekcija sa bazom podataka
     */
    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

}
