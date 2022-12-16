package com.voiture.locations;

import java.util.List;

import com.voiture.Location;

public class ControllerLocation {
    private static ControllerLocation CtrC_Instance = null;
    private static ModelLocation Model_Instance = null;

    private ControllerLocation(){}

    public static synchronized ControllerLocation getControllerLocation(){
        try{
            if(CtrC_Instance == null){
                CtrC_Instance = new ControllerLocation();
                Model_Instance = ModelLocation.getLocationModel();
            }
            return CtrC_Instance;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String CtrC_Enregistrer(Location location){
        return Model_Instance.MdlC_Enregistrer(location);
    }

    public List<Location> CtrC_GetAll(){
        return Model_Instance.MdlC_GetAll();
    }

    public String CtrC_Modifier(Location location){
        return Model_Instance.MdlC_Modifier(location);
    }

    public boolean CtrC_ChercherID(Location location){
        return Model_Instance.MdlC_ChercherID(location);
    }

    public List<Location> CtrC_Chercher(Location location){
        return Model_Instance.MdlC_Chercher(location);
    }

    public String CtrC_Supprimer(Location location){
        return Model_Instance.MdlC_Supprimer(location);
    }
}
