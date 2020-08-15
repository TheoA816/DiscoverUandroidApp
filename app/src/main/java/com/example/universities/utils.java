package com.example.universities;

import java.util.ArrayList;

public class utils {
    private static utils instance;

    private static ArrayList<university> Australia;
    private static ArrayList<university> Singapore;
    private static ArrayList<university> Favorites;
    private static ArrayList<uniCourse> NTU;
    private static ArrayList<uniCourse> NUS;
    private static ArrayList<uniCourse> melU;
    private static ArrayList<uniCourse> UNSW;


    private utils(){
        if(null==Australia){
            Australia=new ArrayList<>();
            initDataAussie();
        }
        if(null==Singapore){
            Singapore=new ArrayList<>();
            initDataSingapore();
        }
        if(null==Favorites){
            Favorites=new ArrayList<>();
        }
        if(null==NTU){
            NTU=new ArrayList<>();
            initDataNTU();
        }
        if(null==NUS){
            NUS=new ArrayList<>();
            initDataNUS();
        }
        if(null==melU){
            melU=new ArrayList<>();
            initDatamelU();
        }
        if(null==UNSW){
            UNSW=new ArrayList<>();
            initDataUNSW();
        }


    }

    private void initDataUNSW() {
    }

    private void initDatamelU() {
    }

    private void initDataNUS() {
    }

    private void initDataNTU() {
        NTU.add(new uniCourse("Computer Science","4 years","$40k SGD","For UN holders\n"+
                "Entrance Exams: \n" +
                "   English\n" +
                "   Mathematics\n" +
                "   Physics\n" +
                "   Chemistry","A Levels: Good Pass in Mathematics and Physics/Chemistry/Biology\n" +
                "IB: HL Mathematics and HL Chemistry/Physics/Biology/Computer Science\n" +
                "SAT not applicable","https://scse.ntu.edu.sg/Pages/Home.aspx","https://purelifi.com/wp-content/uploads/2017/06/Nanyang-Technological-University-Singapore.jpg","16 October 2020"));
    }

    private void initDataSingapore() {
        Singapore.add(new university("Nanyang Technological University",10,"https://purelifi.com/wp-content/uploads/2017/06/Nanyang-Technological-University-Singapore.jpg"
                ,"Singapore", "NTU"));
        Singapore.add(new university("National University of Singapore", 11, "https://lh3.googleusercontent.com/proxy/xhEM5ufuM18ILLnmvqJ9FavjCWq8Lnnkqn_lN_r0F-BO66Mr-yfatEJaCNVqMV2QhfypsHS66tQIMRqemonmTKpH78hpwpiahcDADKJX6lv-E6fM7LLd"
        , "Singapore", "NUS"));
    }

    private void initDataAussie() {
        Australia.add(new university("University of Melbourne", 38, "https://housinginfo.com.au/wp-content/uploads/2020/06/Uni_Melbourne_logo.jpg",
                "Melbourne","MelU"));
        Australia.add(new university("University of New South Wales", 43, "https://www.mivision.com.au/wp-content/uploads/2017/06/landscapecolourpos-n-unsw-logo-web.jpg"
        ,"Sydney","UNSW"));
    }

    public static synchronized utils getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new utils();
            return instance;
        }
    }

    public static ArrayList<university> getAustralia() {
        return Australia;
    }

    public static ArrayList<university> getSingapore() {
        return Singapore;
    }

    public static ArrayList<university> getFavorites() {
        return Favorites;
    }

    public university getUniAussie(Integer rank){
        for(university u: Australia){
            if(u.getQSworldRank()==rank){
                return u;
            }
        }
        return null;
    }

    public university getUniSingapore(Integer rank){
        for(university u: Singapore){
            if(u.getQSworldRank()==rank){
                return u;
            }
        }
        return null;
    }
    public uniCourse getNTU(Integer position){
        return(NTU.get(position));
    }
    public uniCourse getNUS(Integer position){
        return(NUS.get(position));
    }
    public uniCourse getmelU(Integer position){
        return(melU.get(position));
    }
    public uniCourse getUNSW(Integer position){
        return(UNSW.get(position));
    }

    public Boolean addToFavorites(university university){
        return Favorites.add(university);
    }

    public Boolean removeFromFavorites(university university){
        return Favorites.remove(university);
    }

}
