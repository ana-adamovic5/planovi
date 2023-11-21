/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.thread;

import rs.np.planovi.server.controller.ServerController;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.Korisnik;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import rs.np.planovi.zajednicki.transfer.Request;
import rs.np.planovi.zajednicki.transfer.Response;
import rs.np.planovi.zajednicki.transfer.util.ResponseStatus;
import rs.np.planovi.zajednicki.transfer.util.Operation;

/**
 *
 * @author adamo
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_CILJ:
                    ServerController.getInstance().addCilj((Cilj) request.getData());
                    break;
                case Operation.ADD_BELESKA:
                    ServerController.getInstance().addBeleska((Beleska) request.getData());
                    break;
                case Operation.ADD_NEDELJNI_PLAN:
                    ServerController.getInstance().addNedeljniPlan((NedeljniPlan) request.getData());
                    break;
                case Operation.DELETE_CILJ:
                    ServerController.getInstance().deleteCilj((Cilj) request.getData());
                    break;
                case Operation.DELETE_BELESKA:
                    ServerController.getInstance().deleteBeleska((Beleska) request.getData());
                    break;
                case Operation.DELETE_NEDELJNI_PLAN:
                    ServerController.getInstance().deleteNedeljniPlan((NedeljniPlan) request.getData());
                    break;
                case Operation.UPDATE_CILJ:
                    ServerController.getInstance().updateCilj((Cilj) request.getData());
                    break;
                case Operation.UPDATE_BELESKA:
                    ServerController.getInstance().updateBeleska((Beleska) request.getData());
                    break;
                case Operation.UPDATE_NEDELJNI_PLAN:
                    ServerController.getInstance().updateNedeljniPlan((NedeljniPlan) request.getData());
                    break;
                case Operation.GET_ALL_KORISNIK:
                    response.setData(ServerController.getInstance().getAllKorisnik());
                    break;
                case Operation.GET_ALL_AKTIVNOST:
                    response.setData(ServerController.getInstance().getAllAktivnost());
                    break;
                case Operation.GET_ALL_CILJ:
                    response.setData(ServerController.getInstance().getAllCilj());
                    break;
                case Operation.GET_ALL_BELESKA:
                    response.setData(ServerController.getInstance().getAllBeleska());
                    break;
                case Operation.GET_ALL_DNEVNA_AKTIVNOST:
                    response.setData(ServerController.getInstance().getAllDnevnaAktivnost((NedeljniPlan) request.getData()));
                    break;
                case Operation.GET_ALL_NEDELJNI_PLAN:
                    response.setData(ServerController.getInstance().getAllNedeljniPlan());
                    break;
                case Operation.GET_ALL_TIP_AKTIVNOSTI:
                    response.setData(ServerController.getInstance().getAllTipAktivnosti());
                    break;
                case Operation.LOGIN:
                    Korisnik korisnik = (Korisnik) request.getData();
                    Korisnik ulogovani = ServerController.getInstance().login(korisnik);
                    response.setData(ulogovani);
                    break;
                case Operation.GET_ALL_KATEGORIJE:
                    response.setData(ServerController.getInstance().getAllKategorijaCilja());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
