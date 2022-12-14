package com.voiture.voitures;

import java.util.List;

import com.voiture.Voitures;

public class ControllerVoiture {
    private static ControllerVoiture CtrC_Instance = null;
    private static ModelVoiture Model_Instance = null;

    private ControllerVoiture(){}

    public static synchronized ControllerVoiture getControllerVoiture(){
        try{
            if(CtrC_Instance == null){
                CtrC_Instance = new ControllerVoiture();
                Model_Instance = ModelVoiture.getVoitureModel();
            }
            return CtrC_Instance;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String CtrV_Enregistrer(Voitures voiture){
        return Model_Instance.MdlV_Enregistrer(voiture);
    }

    public List<Voitures> CtrV_GetAll(){
        return Model_Instance.MdlV_GetAll();
    }

    public String CtrV_Modifier(Voitures voiture){
        return Model_Instance.MdlV_Modifier(voiture);
    }

    public boolean CtrV_ChercherID(Voitures voiture){
        return Model_Instance.MdlV_ChercherID(voiture);
    }

    public List<Voitures> CtrV_Chercher(Voitures voiture){
        return Model_Instance.MdlV_Chercher(voiture);
    }

    public String CtrV_Supprimer(Voitures voiture){
        return Model_Instance.MdlV_Supprimer(voiture);
    }
}
