package com.example.dracnegre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class repositoriLocals {

    private static repositoriLocals repo_loc = new repositoriLocals();
    private TreeMap<String, llistalocals> lltaloc = new TreeMap<>();

    public static repositoriLocals getInstance() {
        return repo_loc;
    }


    private repositoriLocals(){

        saveLoc(new llistalocals("1","Alaquas","C.A. Alaquàs","Plaça de la Constitució, 1. 46970 ALAQUÀS","686009679","39.3970134","-0.4138396,17"));
        saveLoc(new llistalocals("2","Alborache","C.A. Alborache Piccadilly","Pz/ España nº4 (Escuelas Antiguas). 46369 ALBORACHE","626516426","39.3929035","-0.7743851,14"));
        saveLoc(new llistalocals("3","Aldaia","C.A. Aldaia Educart","Polideportivo Aldaia - C/ Joaquin Blume S/N. 46960 ALDAIA","654136346","39.4606223","-0.4596357,18"));
        saveLoc(new llistalocals("4","Alzira","C.A. Alzira","C/ Pedro Morell,6. 46600. ALZIRA", "667410433", "39.1491082","-0.4405458,17"));
        saveLoc(new llistalocals("5","Basilio","C.D. Basilio.", "46008. VALENCIA", "626816690","39.4727535","-0.389589,13"));
        saveLoc(new llistalocals("6","Benimaclet","C.A. Gambito-Benimaclet","Daniel Balaciart s/n Polideportivo Benimaclet. 46020 VALENCIA","647484846","39.4810591","-0.3545263,17"));
        saveLoc(new llistalocals("7","Buñol","C.A.BUÑOL", "\"Plaza la Yana 2bis (28,93 km). 46360 BUÑOL\"","39.4170123","39.4170123","-0.7888384,17"));
        saveLoc(new llistalocals("8","Burjassot","C.A. Burjassot","C/ Bautista Riera 8 (Círculo Católico). 46100 BURJASSOT","699424531","39.5053766","-0.4078544,17"));
        saveLoc(new llistalocals("9","Ciutat Vella","C.A. Ciutat Vella","C/ Paseo La Pechina 42. 46008 VALENCIA", "626816690","39.475888","-0.393696,17"));
        saveLoc(new llistalocals("19","Dama Roja","C.A. Dama Roja","C/Luis Santángel, 30. 46006 VALENCIA", "600329826","39.4612416","-0.3666761,17"));
        saveLoc(new llistalocals("20","Gandia","C.A. Fomento de Gandia","C/SAN FRANCISCO DE BORJA, 56. 46701 GANDIA","615363141","38.9658895","-0.1829014,17"));
        saveLoc(new llistalocals("21","Massanassa","C.A. Massanassa","Calle Gregorio Mayans, 8 bajo. 46470 MASSANASSA","615395801","39.4110476","-0.401376,17"));
        saveLoc(new llistalocals("22","Mislata","C.A. Mislata Lanjarón Discema","C/ Felipe Bellver, 43. 46920 MISLATA","679921256","39.47524","-0.411274,17"));
        saveLoc(new llistalocals("23","Moncada","C.A. Moncada FDM","C/Luis Vives, 18-1º. 43113 MONCADA", "625858706","39.5458423","-0.3946106,17"));
        saveLoc(new llistalocals("24","Monserrat","C.E. Montserrat","Hogar Jubilados, c/ Mayor. 46192 MONTSERRAT","607154928","39.3564934","-0.5997589,14"));
        saveLoc(new llistalocals("25","Quart","C.A. Ajedrez Quart","Pza País Valenciano , nº 7. 46930 Quart de Poblet","000000000","39.4780371","-0.4225869,17"));
        saveLoc(new llistalocals("26","Torrefiel","C.A. Torrefiel","Asociación cívica El Ventanal, C/ Fray Pedro Vives,13-15. 46009 VALENCIA","656622191","39.4867701","-0.3737708,17"));
        saveLoc(new llistalocals("27","Xativa","C.E. Xátiva","Carrer Abu Masaifa, 9. 46800 XATIVA","601206585","38.9893469","-0.5274009,17"));
        saveLoc(new llistalocals("28","Xeraco","C.A. Xeraco","Plaça del Quartell, s/n (Centre Cívic). 46670 XERACO","657160043","39.3843647","-0.2402383,8"));
    }

    private void saveLoc(llistalocals lead) {
        lltaloc.put(lead.getOrdre(), lead);
    }

    public List<llistalocals> getLeads() {
        return new ArrayList<>(lltaloc.values());
    }
}
