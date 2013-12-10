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
import DTO.objecte.DTORollenList;
import DTO.objecte.DTOVeranstaltung;
import DTO.objecte.DTOVeranstaltungAnzeigen;
import DTO.objecte.DTOVeranstaltungInformation;
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

/**
 *
 * @author Anastasia
 */
@Remote
public interface HelloRemote {
 
   public DTORollenList login(DTOLoginDaten l) throws BenutzerNichtInDBException, FalschesPasswordExeption;
    
   public void neuenKundenSpeichern(DTOKundeNeuSpeichern k) throws SaveFailedException;

   public void kundenDatenAendern(DTOKundenDatenAendern k) throws SaveFailedException;
  
    public ArrayList<DTOVeranstaltungInformation> sucheVeranstaltungenNachKrieterien(Date d, String ort, String kuenstler); 
                   
    public ArrayList<DTOKategorieInformation> getKategorieInfoVonVeranstaltung(DTOVeranstaltungAnzeigen v);
        
    public DTOKategorieInformation getKategorieInfo(int id); 
           
    public DTOKategorieKarte getAlleFreieKartenNachKategorie(DTOKategorienAuswaehlen kat);
   
    public ArrayList<DTOKundenDaten> getKundenListNachNachname(String nachname) throws Exception;

    public DTOKundenDaten getKundendatenNachID(int id) throws Exception;
      
    public void verkaufSpeichern(List<DTOKarteBestellen> karten) throws Exception, SaveFailedException,
            KarteNichtVerfuegbarException;
    
    public void reservierungSpeichern(List<DTOKarteReservieren> karten) 
            throws Exception, SaveFailedException, KarteNichtVerfuegbarException;
    
    public DTOVeranstaltung getVeranstaltungById(int veranstaltungID) throws Exception;
}

