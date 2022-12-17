package com.voiture.locations;

import java.util.List;

import com.voiture.Location;

public class ControllerLocation {
    private static ControllerLocation CtrL_Instance = null;
    private static ModelLocation Model_Instance = null;

    private ControllerLocation(){}

    public static synchronized ControllerLocation getControllerLocation(){
        try{
            if(CtrL_Instance == null){
                CtrL_Instance = new ControllerLocation();
                Model_Instance = ModelLocation.getLocationModel();
            }
            return CtrL_Instance;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<String> CtrL_GetIdClient(){
        return Model_Instance.MdlL_GetIdClient();
    }

    public List<String> CtrL_GetIdVoiture(){
        return Model_Instance.MdlL_GetIdVoiture();
    }
    public String CtrL_Enregistrer(Location location){
        return Model_Instance.MdlL_Enregistrer(location);
    }

    public List<Location> CtrL_GetAll(){
        return Model_Instance.MdlL_GetAll();
    }

    public String CtrL_Modifier(Location location){
        return Model_Instance.MdlL_Modifier(location);
    }

    public boolean CtrL_ChercherID(Location location){
        return Model_Instance.MdlL_ChercherID(location);
    }

    public List<Location> CtrL_Chercher(Location location){
        return Model_Instance.MdlL_Chercher(location);
    }

    public String CtrL_Supprimer(Location location){
        return Model_Instance.MdlL_Supprimer(location);
    }
}
