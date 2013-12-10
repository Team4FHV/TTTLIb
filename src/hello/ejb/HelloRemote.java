/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hello.ejb;

import DTO.objecte.DTOKarte; 
import DTO.objecte.DTOKarteBestellen;
import DTO.objecte.DTOKarteReservieren;
import DTO.objecte.DTOKategorieInformation;
import DTO.objecte.DTOKategorieKarte;
import DTO.objecte.DTOKategorienAuswaehlen;
import DTO.objecte.DTOKundeNeuSpeichern;
import DTO.objecte.DTOKundenDaten;
import DTO.objecte.DTOKundenDatenAendern;
import DTO.objecte.DTOLoginDaten;
import DTO.objecte.DTOMessage;
import DTO.objecte.DTORollenList;
import DTO.objecte.DTOTopicData;
import DTO.objecte.DTOVeranstaltung;
import DTO.objecte.DTOVeranstaltungAnzeigen;
import DTO.objecte.DTOVeranstaltungInformation;
import Exceptions.BenutzerInaktivException;
import Exceptions.BenutzerNichtInDBException;
import Exceptions.FalschesPasswordExeption;
import Exceptions.KarteNichtVerfuegbarException;
import Exceptions.SaveFailedException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.naming.NamingException;

/**
 *
 * @author Anastasia
 */
@Remote
public interface HelloRemote {
  
    public DTORollenList login(DTOLoginDaten l) 
            throws RemoteException, BenutzerNichtInDBException, FalschesPasswordExeption;
    
    public void neuenKundenSpeichern(DTOKundeNeuSpeichern k) throws RemoteException, SaveFailedException ;
   
    public void kundenDatenAendern(DTOKundenDatenAendern k) throws RemoteException, SaveFailedException;
   
    public ArrayList<DTOVeranstaltungInformation> sucheVeranstaltungenNachKrieterien
        (Date d, String ort, String kuenstler) throws RemoteException;
        
    public ArrayList<DTOKategorieInformation> getKategorieInfoVonVeranstaltung
        (DTOVeranstaltungAnzeigen v) throws RemoteException;
        
        public DTOKategorieInformation getKategorieInfo(int id) throws RemoteException;
        
    public DTOKategorieKarte getAlleFreieKartenNachKategorie(DTOKategorienAuswaehlen kat) throws RemoteException;
    
    public ArrayList<DTOKundenDaten> getKundenListNachNachname(String nachname) throws RemoteException, Exception;
    
    public DTOKundenDaten getKundendatenNachID(int id) throws Exception, RemoteException;
   
    public void verkaufSpeichern(List<DTOKarteBestellen> karten) 
            throws Exception, RemoteException, SaveFailedException, KarteNichtVerfuegbarException;
   
    public void reservierungSpeichern(List<DTOKarteReservieren> karten) 
            throws Exception, RemoteException, SaveFailedException, KarteNichtVerfuegbarException;
    
    public DTOVeranstaltung getVeranstaltungById(int veranstaltungID) throws RemoteException;
    
    public List<DTOMessage> loadUnpublishedMessages()throws RemoteException;
    
    public ArrayList<DTOTopicData> getTopics() throws RemoteException;

    public void publishMessage(DTOMessage message) throws RemoteException;

     public void addMessageToClient(DTOMessage m)  throws RemoteException;
    
    public ArrayList<DTOTopicData> getTopicsVonBenutzer(String name) throws RemoteException;
       
}

   